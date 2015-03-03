package com.modoop.admin.service.dao;

import com.modoop.admin.entity.Permission;
import com.modoop.admin.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Genkyo Lee
 */
@Repository
public interface RoleDao
{
    List<Role> findAll();

    List<Role> search(Map<String, Object> parameters);

    long count(Map<String, Object> parameters);

    List<Permission> findPermissions();

    Role find(Long id);

    void create(Role role);

    int update(Role role);

    void delete(Long id);
}
