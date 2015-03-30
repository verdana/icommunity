package com.modoop.data.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Genkyo Lee
 */
public class Admin extends IdEntity implements Stateful, Serializable
{
    private static final long serialVersionUID = -8298838450565454455L;

    public static final String KEY = "管理员";

    //Properties
    @NotBlank(message = "名称不能为空。")
    @Pattern(regexp = "^[a-z0-9.]+$", message = "请勿使用除字母 (a-z)、数字和英文句号外的其他字符。")
    private String name;

    private String trueName;

    @Length(min = 6, max = 15, message = "过短的密码很容易被猜到。请尝试使用至少包含 {min} 到 {max} 个字符的密码。")
    private String password;

    private String phone;

    private String mobile;

    @Email(message = "输入内容不是一个合法格式的电子邮件地址。")
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
