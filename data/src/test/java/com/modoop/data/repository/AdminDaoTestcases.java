package com.modoop.data.repository;

import com.modoop.data.AbstractTestcases;
import com.modoop.data.entity.Admin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Roger Lee
 */
public class AdminDaoTestcases extends AbstractTestcases
{
    @Autowired
    private AdminDao dao;

    @Test
    public void testRead()
    {
        Admin admin = dao.find(1l);
        System.out.println("admin >>> " + admin);
    }


    @Test
    public void testDelete()
    {
        Admin admin = dao.findByName("admin");
        dao.delete(admin.getId());
    }
}
