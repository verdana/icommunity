package com.modoop.admin.exception;

import com.modoop.core.exception.ServiceException;

/**
 * Exception thrown when some entity has already existed.
 *
 * @author Genkyo Lee
 */
public class EntityAlreadyExistException extends ServiceException
{
    private static final long serialVersionUID = -8396495368045207838L;

    //Properties
    private static final String BASE_KEY = "{0} {1} 已经存在！";

    //Constructors
    public EntityAlreadyExistException(String msg)
    {
        super(msg);
    }

    /**
     * <pre>
     * throw new EntityAlreadyExistException("entity.user", "genkyo");
     * </pre>
     *
     * @param entityKey   实体的类型的字典key
     * @param entityValue 实体的主键
     */
    public EntityAlreadyExistException(String entityKey, Object entityValue)
    {
        super(BASE_KEY, new Object[]{entityKey, entityValue});
    }
} // end class
