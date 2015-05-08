package com.modoop.data.entity;

import java.io.Serializable;

/**
 * @author Genkyo Lee
 */
public class User extends IdEntity implements Serializable
{
    private static final long serialVersionUID = -8298838450565454455L;

    public static final String KEY = "用户";

    //Properties
    private String mobile;

    private String name;

    private String trueName;

    private String nickName;

    private String idCard;

    private Integer gender;

    private Integer age;

    private String password;

    private String phone;

    private String email;

    private String description;

    //Constructors
    public User()
    {
    }

    public User(String mobile)
    {
        this.mobile = mobile;
    }

    public User(Long id, String mobile)
    {
        this.id = id;
        this.mobile = mobile;
    }

    //Methods
    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
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

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getIdCard()
    {
        return idCard;
    }

    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public Integer getGender()
    {
        return gender;
    }

    public void setGender(Integer gender)
    {
        this.gender = gender;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return jsonMapper.toJson(this);
    }
} // end class
