package com.modoop.admin.entity;

import com.modoop.core.mapper.JsonMapper;

/**
 * @author Genkyo Lee
 */
public abstract class IdEntity
{
    protected JsonMapper jsonMapper = JsonMapper.buildNonEmptyMapper();

    protected Long id;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
