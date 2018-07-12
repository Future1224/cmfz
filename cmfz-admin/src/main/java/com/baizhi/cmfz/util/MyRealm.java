package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-11 20:15
 */
public class MyRealm extends AuthorizingRealm {


    @Autowired
    private AdminService as;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();


        try {
            List<Role> roles = as.queryRoleByAdminName(userName);
            if(roles!=null){
                for (Role role : roles) {
                    info.addRole(role.getRoleTag());
                }
            }
            List<Permission> permissions = as.queryPermissionByAdminName(userName);
            if(permissions!=null){
                for (Permission permission : permissions) {
                    info.addStringPermission(permission.getPermissionTag());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        try {
            Admin admin = as.queryByName(userName);
            if(admin!=null){

                return new SimpleAuthenticationInfo(admin.getAdminName(),admin.getAdminPassword(),ByteSource.Util.bytes(admin.getAdminSalt()), UUID.randomUUID().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


        return null;
    }
}
