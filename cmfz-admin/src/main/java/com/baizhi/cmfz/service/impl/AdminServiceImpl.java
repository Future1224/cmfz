package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:管理员业务实现类
 *
 * @author future_zwp
 * @create 2018-07-04 14:52
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao ad;


    /**
     * 描述:管理员登录业务方法
     *
     * @author future_zwp
     * @Date 2018/7/5 8:43
     * @Param [adminName, adminPassword]
     * @return com.baizhi.cmfz.entity.Admin
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin login(String adminName, String adminPassword)throws Exception {
        Admin admin = ad.selectByName(adminName);
        //md5加密       password+salt
        if(admin!=null&&admin.getAdminPassword().equals(DigestUtils.md5Hex(adminPassword+admin.getAdminSalt()))){
            return admin;
        }
        return null;
    }

    /**
     * 描述:根据用户名查询管理员信息
     *
     * @author future_zwp
     * @Date 2018/7/5 8:44
     * @Param [adminName]
     * @return com.baizhi.cmfz.entity.Admin
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin queryByName(String adminName)throws Exception {
        return ad.selectByName(adminName);
    }



    /**
     * 描述:
     *
     * @author future_zwp
     * @Date 2018/7/8 22:59
     * @Param [admin]
     * @return java.lang.Boolean
     */
    @Override
    public void addAdmin(Admin admin)throws Exception{
        String s = RandomStringUtils.randomAlphanumeric(5);
        admin.setAdminSalt(s);
        admin.setAdminPassword(DigestUtils.md5Hex(admin.getAdminPassword()+s));
        Integer i = ad.insertAdmin(admin);
        if(i<=0){
                throw new RuntimeException("管理员添加失败！");
            }

    }

    /**
     * 描述:
     *
     * @author future_zwp
     * @Date 2018/7/5 8:36
     * @Param [adminName]
     * @return java.lang.Boolean
     */
    @Override
    public void removeAdmin(String adminName)throws Exception {
        Integer i = ad.deleteAdmin(adminName);
        if(i<=0){
            throw new RuntimeException("管理员修改失败！");
        }
    }


    /**
     * 描述:
     *
     * @author future_zwp
     * @Date 2018/7/5 8:35
     * @Param [admin]
     * @return java.lang.Boolean
     */
    @Override
    public void modifyAdmin(Admin admin)throws Exception {


    }

}
