package com.modoop.rest.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Genkyo Lee
 */
public class Admin extends IdEntity implements Stateful, Serializable
{
    private static final long serialVersionUID = -8298838450565454455L;

    //Properties
    private String name;

    private String trueName;

    private String password;

    private String phone;

    private String mobile;

    private String email;

    private Integer state;

    private String description;

    private Date createTime;

    private Long version;

    private Role role;

    //Constructors
    public Admin()
    {
    }

    public Admin(String name)
    {
        this.name = name;
    }

    public Admin(Long id, String name)
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

    public String getTrueName()
    {
        return trueName;
    }

    public void setTrueName(String trueName)
    {
        this.trueName = trueName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
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

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return jsonMapper.toJson(this);
    }
} // end class
