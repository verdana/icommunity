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
                                "id", "name", "trueName", "phone", "mobile", "email", "state", "description", "createTime", "role"
                        }
        )
@XmlRootElement(name = "admin")
public class AdminDTO implements Serializable
{
    private static final long serialVersionUID = -7882041278038133702L;

    private Long id;

    private String name;

    private String trueName;

    private String phone;

    private String mobile;

    private String email;

    private Integer state;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss a z", timezone = "GMT+8")
    private Date createTime;

    private RoleDTO role;


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

    public String getTrueName()
    {
        return trueName;
    }

    public void setTrueName(String trueName)
    {
        this.trueName = trueName;
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

    public RoleDTO getRole()
    {
        return role;
    }

    public void setRole(RoleDTO role)
    {
        this.role = role;
    }
}
