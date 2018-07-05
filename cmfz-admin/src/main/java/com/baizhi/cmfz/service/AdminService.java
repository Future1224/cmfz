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
    public Admin login(String name, String password);


    /**
     * 描述: 根据管理员用户名查询管理员信息
     *
     * @author future_zwp
     * @date 2018/7/4 22:19
     * @param [name]
     * @return com.baizhi.cmfz.entity.Admin
     */
    public Admin queryByName(String name);



    public Boolean addAdmin(Admin admin);
    public Boolean removeAdmin(String adminName);
    public Boolean modifyAdmin(Admin admin);
}
