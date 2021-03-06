package com.modoop.rest.service;

import com.modoop.data.entity.Admin;
import com.modoop.data.repository.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Genkyo Lee
 */
@Service
public class AdminService extends AbstractService
{
    @Autowired
    private AdminDao adminDao;

    public Admin find(final Long id)
    {
        return adminDao.find(id);
    }
}
