package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 描述:后台管理员Dao
 *
 * @author future_zwp
 * @create 2018-07-04 14:45
 */
public interface AdminDao {

    /**
     * 描述:根据管理员用户名查询数据库信息
     *
     * @author future_zwp
     * @date 2018/7/4 21:54
     * @param
     * @return com.baizhi.cmfz.entity.Admin
     */
    public Admin selectByName(@Param("adminName") String adminName);


    /**
     * 描述: 添加管理员
     *
     * @author future_zwp
     * @date 2018/7/4 22:00
     * @param
     * @return java.lang.Integer
     */
    public Integer insertAdmin(Admin admin);


    /**
     * 描述: 根据管理员用户名删除一个管理员
     *
     * @author future_zwp
     * @date 2018/7/4 22:01
     * @param
     * @return java.lang.Integer
     */
    public Integer deleteAdmin(@Param("adminName") String adminName);


    /**
     * 描述: 修改管理员信息
     *
     * @author future_zwp
     * @date 2018/7/4 22:03
     * @param
     * @return java.lang.Integer
     */
    public Integer updateAdmin(Admin admin);


    public List<Role> selectRoleByAdminName(@Param("adminName") String adminName);

    public List<Permission> selectPermissionByAdminName(@Param("adminName") String adminName);




}
