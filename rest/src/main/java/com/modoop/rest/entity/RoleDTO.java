package com.modoop.rest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.modoop.core.constant.Constants;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Roger Lee
 */
@XmlType
        (
                namespace = Constants.NS,
                propOrder =
                        {
                                "id", "name", "permissions", "description", "createTime"
                        }
        )
@XmlRootElement(name = "role")
public class RoleDTO implements Serializable
{
    private static final long serialVersionUID = -4284436677344152180L;

    private Long id;

    private String name;

    private String permissions;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss a z", timezone = "GMT+8")
    private Date createTime;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPermissions()
    {
        return permissions;
    }

    public void setPermissions(String permissions)
    {
        this.permissions = permissions;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
}
