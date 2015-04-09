package com.modoop.rest.controller;

import com.google.common.base.Stopwatch;
import com.modoop.core.mapper.BeanMapper;
import com.modoop.data.entity.Admin;
import com.modoop.rest.entity.AdminDTO;
import com.modoop.rest.exception.RestException;
import com.modoop.rest.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Roger Lee
 */
@RestController
@RequestMapping(value = {"/api/admin"})
public class AdminRestController
{
    private static Logger logger = LoggerFactory.getLogger(AdminRestController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AdminDTO getAdmin(@PathVariable("id") Long id)
    {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        try
        {
            Admin admin = adminService.find(id);
            if (admin == null)
            {
                String message = "User do not exist(id:" + id + ")";
                logger.warn(message);
                throw new RestException(HttpStatus.NOT_FOUND, message);
            }
            return BeanMapper.map(admin, AdminDTO.class);
        }
        finally
        {
            stopwatch.stop();
            logger.debug("REST.GetUser: {}", stopwatch.toString());
        }
    }
}
