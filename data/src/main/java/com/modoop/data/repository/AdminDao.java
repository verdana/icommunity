package com.modoop.data.repository;

import com.modoop.data.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Roger Lee
 */
@Repository
public interface AdminDao
{
    List<Admin> search(Map<String, Object> parameters);

    long count(Map<String, Object> parameters);

    Admin find(Long id);

    Admin findByName(String name);

    void create(Admin admin);

    void createAdminXRole(Admin admin);

    int update(Admin admin);

    void updateAdminXRole(Admin admin);

    void delete(Long id);
}
