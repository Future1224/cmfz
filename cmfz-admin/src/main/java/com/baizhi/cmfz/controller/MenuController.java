package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 描述:菜单控制器
 *
 * @author future_zwp
 * @create 2018-07-05 13:12
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService ms;


    /**
     * 描述:查询所有一级二级菜单
     *
     * @author future_zwp
     * @Date 2018/7/7 21:01
     * @Param []
     * @return java.util.List<com.baizhi.cmfz.entity.Menu>
     */

    @RequestMapping("/getMenu")
    @ResponseBody
    public List<Menu> getMenu(){
        List<Menu> menus = ms.queryAll();

        return menus;
    }
}
