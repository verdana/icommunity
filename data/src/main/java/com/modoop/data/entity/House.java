package com.modoop.data.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Genkyo Lee
 */
public class House extends IdEntity implements Serializable
{
   public static final String KEY = "户型";
    //Properties
    @NotBlank(message = "名称不能为空。")
    private String name;

    private int type=0;

    private float area=0f;

    private double price=0;


    private BigDecimal totalPrice = new BigDecimal(0) ;

    private float discount=0;

    private String description;

    private Date createTime;

    private Long version;

    //Constructors
    public House()
    {
    }


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public House(String name)
    {
        this.name = name;
    }

    public House(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    @Override
    public String toString()
    {
        return jsonMapper.toJson(this);
    }
} // end class
