package com.modoop.admin.exception;

import com.modoop.core.exception.ServiceException;

/**
 * @author Roger Lee
 */
public class EntityAlreadyChangedException extends ServiceException
{
    private static final long serialVersionUID = 3516262839725687680L;

    private static final String BASE_KEY = "{0} {1} 已经被修改，请刷新后重新尝试！";

    public EntityAlreadyChangedException(String msg)
    {
        super(msg);
    }

    public EntityAlreadyChangedException(String entityKey, Object entityValue)
    {
        super(BASE_KEY, new Object[]{entityKey, entityValue});
    }
} // end class