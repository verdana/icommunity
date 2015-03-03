package com.modoop.admin.service;

import com.modoop.admin.entity.Permission;
import com.modoop.admin.entity.Role;
import com.modoop.admin.exception.EntityAlreadyChangedException;
import com.modoop.admin.exception.EntityCantDeleteException;
import com.modoop.admin.exception.EntityCantModifyException;
import com.modoop.admin.exception.EntityNotFoundException;
import com.modoop.admin.service.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Genkyo Lee
 */
@Service
public class RoleService extends AbstractService
{
    @Autowired
    private RoleDao roleDao;

    public Page<Role> search(Map<String, Object> searchParams, int pageNumber, int pageSize)
    {
        Map<String, Object> parameters = buildParameters(searchParams, pageNumber, pageSize);
        Pageable pageable = buildPageRequest(pageNumber, pageSize);

        List<Role> list = roleDao.search(parameters);
        long total = roleDao.count(parameters);

        return new PageImpl<>(list, pageable, total);
    }

    public Role find(final Long id)
    {
        Role role = roleDao.find(id);
        if (role == null) throw new EntityNotFoundException(Role.KEY, id);
        return role;
    }

    public List<Permission> findPermissions()
    {
        return roleDao.findPermissions();
    }

    @Transactional
    public void create(Role role)
    {
        role.setCreateTime(new Date());
        roleDao.create(role);
    }

    @Transactional
    public Role update(Role role)
    {
        if (isRoot(role))
        {
            throw new EntityCantModifyException(Role.KEY, role.getName());
        }

        int changes = roleDao.update(role);
        if (changes == 0)
        {
            throw new EntityAlreadyChangedException(Role.KEY, role.getName());
        }
        return role;
    }

    @Transactional
    public void delete(Long id)
    {
        Role role = find(id);
        if (isRoot(role))
        {
            throw new EntityCantDeleteException(Role.KEY, role.getName());
        }

        roleDao.delete(id);
    }

    /**
     * 判断是否超级管理员权限.
     */
    private boolean isRoot(Role role)
    {
        return (role.getId() != null && role.getId() == 1L);
    }
}
