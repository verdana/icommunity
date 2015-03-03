package com.modoop.admin.exception;

import com.modoop.core.exception.ServiceException;

/**
 * @author Genkyo Lee
 */
public class EntityCantDeleteException extends ServiceException
{
    private static final long serialVersionUID = 3960225693305875818L;
    //Properties
    private static final String BASE_KEY = "不能删除系统默认{0} {1}！";

    /**
     * 用一个消息的key构造，仅仅简单的说明。
     */
    public EntityCantDeleteException(String msg)
    {
        super(msg);
    }


    /**
     * 指明没有找到的实体的类型key和具体的实体主键. 如：
     * <pre>
     * throw new EntityNotFoundException("entity.user", "leeaee");
     * or
     * throw new EntityNotFoundException(EntityNotFoundException.GROUP, "sun");
     * </pre>
     *
     * @param entityKey 实体的类型的字典key
     * @param entityId  实体的主键
     */
    public EntityCantDeleteException(String entityKey, Object entityId)
    {
        super(BASE_KEY, new Object[]{entityKey, entityId});
    }
}
