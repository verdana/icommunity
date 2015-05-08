package com.modoop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

/**
 * @author Genkyo Lee
 */
public class Role extends IdEntity implements Serializable
{
    private static final long serialVersionUID = 520695627881046030L;

    public static final String KEY = "角色";

    //Properties
    @NotBlank(message = "名称不能为空。")
    private String name;

    @NotBlank(message = "权限不能为空。")
    private String permissions;

    private String description;


    //Constructors
    public Role()
    {
    }

    public Role(Long id)
    {
        this.id = id;
    }

    public Role(String name)
    {
        this.name = name;
    }

    public Role(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    //Methods
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

    @JsonIgnore
    public List<String> getPermissionList()
    {
        return ImmutableList.copyOf(StringUtils.split(permissions, ","));
    }

    @Override
    public String toString()
    {
        return jsonMapper.toJson(this);
    }
} //end class