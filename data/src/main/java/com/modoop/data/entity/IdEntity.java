package com.modoop.data.entity;

import com.modoop.core.mapper.JsonMapper;

import java.util.Date;

/**
 * @author Genkyo Lee
 */
public abstract class IdEntity
{
    protected JsonMapper jsonMapper = JsonMapper.buildNonEmptyMapper();

    protected Long id;

    protected Date createTime;

    protected Long version;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }
}
