package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-05 13:09
 */
public interface MenuService {
    public List<Menu> queryAll()throws Exception;
}
