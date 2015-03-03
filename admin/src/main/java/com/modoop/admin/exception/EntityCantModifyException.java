package com.modoop.admin.exception;

import com.modoop.core.exception.ServiceException;

/**
 * @author Genkyo Lee
 */
public class EntityCantModifyException extends ServiceException
{
    private static final long serialVersionUID = 8726155073924715415L;

    private static final String BASE_KEY = "不能修改系统默认{0} {1}！";

    /**
     *  返回的错误信息.
     */

    //Constructor
    /**
     * 用一个消息的key构造，仅仅简单的说明。
     */
    public EntityCantModifyException(String msg) {
        super(msg);
    }

    /**
     * 指明没有找到的实体的类型key和具体的实体主键. 如：
     * <pre>
     * throw new EntityNotFoundException("entity.user", "genkyo");
     * or
     * throw new EntityNotFoundException(EntityNotFoundException.GROUP, "sun");
     * </pre>
     *
     * @param entityKey 实体的类型的字典key
     * @param entityId  实体的主键
     */
    public EntityCantModifyException(String entityKey, Object entityId) {
        super(BASE_KEY, new Object[]{entityKey, entityId});
    }
}
