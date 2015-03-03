package com.modoop.admin.exception;


import com.modoop.core.exception.ServiceException;

/**
 * @author Genkyo Lee
 */
public class EntityNotFoundException extends ServiceException
{
    private static final long serialVersionUID = -1732421582718005304L;

    //Properties
    private static final String BASE_KEY = "{0} {1} 不存在！";

    //Constructor
    public EntityNotFoundException(String msg)
    {
        super(msg);
    }

    /**
     * 指明没有找到的实体的类型key和具体的实体主键. 如：
     * <p/>
     * <pre>
     * throw new EntityNotFoundException("entity.user", "genkyo");
     * </pre>
     *
     * @param entityKey 实体的类型的字典key
     * @param entityValue  实体的值
     */
    public EntityNotFoundException(String entityKey, Object entityValue)
    {
        super(BASE_KEY, new Object[]{entityKey, entityValue});
    }
} // end class