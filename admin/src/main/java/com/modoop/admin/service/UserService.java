package com.modoop.admin.service;

import com.modoop.admin.exception.*;
import com.modoop.admin.shiro.ShiroDbRealm;
import com.modoop.admin.shiro.ShiroUser;
import com.modoop.core.util.StringUtils;
import com.modoop.data.entity.Admin;
import com.modoop.data.entity.Role;
import com.modoop.data.entity.User;
import com.modoop.data.repository.AdminDao;
import com.modoop.data.repository.RoleDao;
import com.modoop.data.repository.UserDao;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Genkyo Lee
 */
@Service
public class UserService extends AbstractService
{
    @Autowired
    private UserDao userDao;

    public Page<User> search(Map<String, Object> searchParams, int pageNumber, int pageSize)
    {
        Map<String, Object> parameters = buildParameters(searchParams, pageNumber, pageSize);
        Pageable pageable = buildPageRequest(pageNumber, pageSize);

        List<User> list = userDao.search(parameters);
        long total = userDao.count(parameters);

        return new PageImpl<>(list, pageable, total);
    }

    public User find(final Long id)
    {
        User user = userDao.find(id);
        if (user == null) throw new EntityNotFoundException(User.KEY, id);
        return user;
    }

//    @Transactional
//    public void create(Admin admin)
//    {
//        Admin temp = adminDao.findByName(admin.getName());
//        if (temp != null) throw new EntityAlreadyExistException(Admin.KEY, admin.getName());
//        if (admin.getState() == null) admin.setState(4);
//        admin.setPassword(BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt()));
//        admin.setCreateTime(new Date());
//        adminDao.create(admin);
//    }

//    @Transactional
//    public Admin update(Admin admin)
//    {
//        if (isSupervisor(admin))
//        {
//            throw new EntityCantModifyException(Admin.KEY, admin.getName());
//        }
//
//        if (StringUtils.isNotBlank(admin.getPassword()))
//        {
//            admin.setPassword(BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt()));
//        }
//
//        int changes = adminDao.update(admin);
//        if (changes == 0)
//        {
//            throw new EntityAlreadyChangedException(Admin.KEY, admin.getName());
//        }
//        return admin;
//    }
//
//    @Transactional
//    public void delete(Long id)
//    {
//        Admin admin = find(id);
//        if (isSupervisor(admin) || getCurrentUserName().equals(admin.getName()))
//        {
//            throw new EntityCantDeleteException(Admin.KEY, admin.getTrueName());
//        }
//        adminDao.delete(id);
//    }
}
