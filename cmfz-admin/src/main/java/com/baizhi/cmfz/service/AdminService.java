package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;

/**
 * 描述:管理员业务接口
 *
 * @author future_zwp
 * @create 2018-07-04 14:47
 */
public interface AdminService {

    /**
     * 描述:
     *
     * @author future_zwp
     * @date 2018/7/4 22:20
     * @param
     * @return
     */
    public Admin login(String name, String password)throws Exception;


    /**
     * 描述: 根据管理员用户名查询管理员信息
     *
     * @author future_zwp
     * @date 2018/7/4 22:19
     * @param
     * @return com.baizhi.cmfz.entity.Admin
     */
    public Admin queryByName(String name)throws Exception;



    public void addAdmin(Admin admin)throws Exception;
    public void removeAdmin(String adminName)throws Exception;
    public void modifyAdmin(Admin admin)throws Exception;
}
