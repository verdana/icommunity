package com.modoop.admin.shiro;

import com.modoop.data.entity.Admin;
import com.modoop.data.entity.Role;
import com.modoop.data.repository.AdminDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author Genkyo Lee
 */
public class ShiroDbRealm extends AuthorizingRealm
{
    @Autowired
    private AdminDao adminDao;

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException
    {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Admin admin = adminDao.findByName(token.getUsername());
        if (admin != null)
        {
            if (admin.getState() > 0 /** 详见Stateful状态值 **/)
            {
                throw new DisabledAccountException();
            }
            return new SimpleAuthenticationInfo(new ShiroUser(admin.getName(), admin.getTrueName()), admin.getPassword(), getName());
        }
        else
        {
            String msg = "Realm was unable to find account data for the submitted AuthenticationToken " + token.getUsername() + ".";
            throw new UnknownAccountException(msg);
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        Admin admin = adminDao.findByName(shiroUser.loginName);
        Role role = admin.getRole();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole(role.getName());
        info.addStringPermissions(role.getPermissionList());
        return info;
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher()
    {
        CustomCredentialsMatcher matcher = new CustomCredentialsMatcher();
        setCredentialsMatcher(matcher);
    }

    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(String principal)
    {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCache(principals);
    }
} // end class
