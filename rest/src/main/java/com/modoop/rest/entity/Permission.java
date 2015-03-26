package com.modoop.rest.entity;

import java.io.Serializable;

/**
 * @author Roger Lee
 */
public class Permission extends IdEntity implements Serializable
{
    private static final long serialVersionUID = 9104681031303022032L;

    private String name;

    private String permit;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPermit()
    {
        return permit;
    }

    public void setPermit(String permit)
    {
        this.permit = permit;
    }

    @Override
    public String toString()
    {
        return jsonMapper.toJson(this);
    }
}
