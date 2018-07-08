package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述:菜单业务层
 *
 * @author future_zwp
 * @create 2018-07-05 13:10
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao md;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAll() {
        return md.selectAll();
    }
}
