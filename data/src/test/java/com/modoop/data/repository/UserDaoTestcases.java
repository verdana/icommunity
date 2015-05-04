package com.modoop.data.repository;

import com.modoop.data.AbstractTestcases;
import com.modoop.data.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Roger Lee
 */
public class UserDaoTestcases extends AbstractTestcases
{
    @Autowired
    private UserDao dao;

    @Test
    public void testCreate()
    {
        User user = new User("18615700105");
        user.setTrueName("Lee");
        user.setGender(-1);
        dao.create(user);
    }

    @Test
    public void testFind()
    {
        User user = dao.find(1L);
        System.out.println("user: " + user);
    }

    @Test
    public void testDelete()
    {
        dao.delete(1L);
    }
}
