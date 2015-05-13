package com.modoop.data.repository;

import com.modoop.data.AbstractTestcases;
import com.modoop.data.entity.Contract;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author Roger Lee
 */
public class ContractDaoTestcases extends AbstractTestcases
{
    @Autowired
    private ContractDao dao;

    @Test
    public void testCreate()
    {
        Contract c = new Contract();
        c.setNumber("SN-20150505-001");
        BigDecimal price = new BigDecimal(10000);
        c.setPrice(price);

        dao.create(c);
    }

    @Test
    public void testFind()
    {
        Contract c = dao.find(1L);
        System.out.println("Contract: " + c);
    }
}
