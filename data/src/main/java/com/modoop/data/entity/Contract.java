package com.modoop.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Roger Lee
 */
public class Contract extends IdEntity implements Serializable
{
    private static final long serialVersionUID = -8458457248451075294L;

    public static final String KEY = "房产交易";

    private String number;

    private BigDecimal price;

    private Date contractTime;

    private String description;


    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public Date getContractTime()
    {
        return contractTime;
    }

    public void setContractTime(Date contractTime)
    {
        this.contractTime = contractTime;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
