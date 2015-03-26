package com.modoop.rest.service.dao;

import com.modoop.rest.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * @author Roger Lee
 */
@Repository
public interface AdminDao
{
    Admin find(Long id);

    Admin findByName(String name);
}
