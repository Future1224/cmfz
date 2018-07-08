package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-05 11:27
 */
public interface MenuDao {

    /**
     * 描述: 查询数据库菜单表中所有的菜单信息
     *
     * @author future_zwp
     * @Date 2018/7/7 21:04
     * @Param []
     * @return java.util.List<com.baizhi.cmfz.entity.Menu>
     */
    public List<Menu> selectAll();
}
