package com.modoop.core.mapper;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * @author Genkyo Lee
 */
public class JsonMapper
{
    private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);

    private ObjectMapper mapper;

    public JsonMapper(Include include)
    {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(include);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * 创建输出全部属性到Json字符串的Mapper。
     */
    public static JsonMapper buildNormalMapper()
    {
        return new JsonMapper(Include.ALWAYS);
    }

    /**
     * 创建只输出非空属性到Json字符串的Mapper。
     */
    public static JsonMapper buildNonNullMapper()
    {
        return new JsonMapper(Include.NON_NULL);
    }

    /**
     * 创建只输出初始值被改变的属性到Json字符串的Mapper。
     */
    public static JsonMapper buildNonDefaultMapper()
    {
        return new JsonMapper(Include.NON_DEFAULT);
    }

    /**
     * 创建只输出非Null且非Empty(如List.isEmpty)的属性到Json字符串的Mapper。
     */
    public static JsonMapper buildNonEmptyMapper()
    {
        return new JsonMapper(Include.NON_EMPTY);
    }

    /**
     * Object可以是POJO, 也可以是Collection或数组.
     * 如果对象为Null, 返回"null".
     * 如果集合为空集合, 返回"[]".
     */
    public String toJson(Object object)
    {
        try
        {
            return mapper.writeValueAsString(object);
        }
        catch (IOException e)
        {
            logger.warn("write to json string error: " + object, e);
            return null;
        }
    }

    /**
     * 如果JSON字符串为Null或"null"字符串，返回Null。
     * 如果JSON字符串为"[]"，返回空集合。
     * <p/>
     * 如需读取集合如List/Map，且不是List<String>这种简单类型时，先使用函数constructParametricType构造类型。
     *
     * @see #constructParametricType(Class, Class...)
     */
    public <T> T fromJson(String jsonString, Class<T> clazz)
    {
        if (StringUtils.isEmpty(jsonString))
        {
            return null;
        }

        try
        {
            return mapper.readValue(jsonString, clazz);
        }
        catch (IOException e)
        {
            logger.warn("parse json string error: " + jsonString, e);
            return null;
        }
    }

    /**
     * 如果JSON字符串为Null或"null"字符串, 返回Null.
     * 如果JSON字符串为"[]", 返回空集合。
     * <p/>
     * 如需读取集合如List/Map, 且不是List<String>这种简单类型时,先使用函数constructParametricType构造类型。
     *
     * @see #constructParametricType(Class, Class...)
     */
    public <T> T fromJson(String jsonString, JavaType javaType)
    {
        if (StringUtils.isEmpty(jsonString))
        {
            return null;
        }

        try
        {
            return mapper.readValue(jsonString, javaType);
        }
        catch (IOException e)
        {
            logger.warn("parse json string error: " + jsonString, e);
            return null;
        }
    }

    /**
     * 构造泛型的Type如List<MyBean>，则调用constructParametricType(ArrayList.class,MyBean.class)
     * Map<String,MyBean>则调用(HashMap.class, String.class, MyBean.class)
     */
    @Deprecated
    public JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses)
    {
        return mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    /**
     * 构造泛型的Type如List<MyBean>，则调用constructParametricType(ArrayList.class,MyBean.class)
     */
    public CollectionType constructCollectionType(Class<? extends Collection> collectClass, Class<?> elementClass)
    {
        return mapper.getTypeFactory().constructCollectionType(collectClass, elementClass);
    }

    /**
     * 构造泛型的Type如Map<String,MyBean>则调用(HashMap.class, String.class, MyBean.class)
     */
    public MapType constructCollectionType(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass)
    {
        return mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
    }

    /**
     * 当JSON里只含有Bean的部分属性時，更新一个已存在Bean，只覆盖部分属性。
     */
    public <T> T update(T object, String jsonString)
    {
        try
        {
            return mapper.readerForUpdating(object).readValue(jsonString);
        }
        catch (IOException e)
        {
            logger.warn("update json string: " + jsonString + " to object: " + object + " error.", e);
        }
        return null;
    }

    /**
     * 输出JSONP格式数据。
     */
    public String toJsonP(String functionName, Object object)
    {
        return toJson(new JSONPObject(functionName, object));
    }

    /**
     * 设定是否使用Enum的toString函数来读写Enum，为False时，使用Enum的name()函数来读写Enum，默认为False。
     * 注意本函数一定要在Mapper创建后, 所有的读写动作之前调用。
     */
    public void setEnumUseToString(boolean value)
    {
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, value);
        mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, value);
    }

    /**
     * 取出Mapper做进一步的设置或使用其他序列化API。
     */
    public ObjectMapper getMapper()
    {
        return mapper;
    }
} // end class
