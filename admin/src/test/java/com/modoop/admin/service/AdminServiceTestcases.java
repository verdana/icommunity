package com.modoop.admin.service;

import com.modoop.admin.AbstractTestcases;
import com.modoop.data.entity.Admin;
import com.modoop.data.entity.Role;
import com.modoop.data.repository.AdminDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Genkyo Lee
 */

public class AdminServiceTestcases extends AbstractTestcases
{
    @Autowired
    private AdminService service;

    @Autowired
    private AdminDao dao;

    @Test
    public void testAddAdmin()
    {
        Admin admin = new Admin();
        admin.setName("admin");
        admin.setPassword("111111");
        admin.setRole(new Role(1L));
        service.create(admin);
        System.out.println("create admin: " + admin);
    }

    @Test
    public void testDelAdmin()
    {
        Admin admin = service.findByName("admin");
        dao.delete(admin.getId());
        System.out.println("delete admin.");
    }
}
