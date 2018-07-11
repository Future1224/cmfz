package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

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
        return null;
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
