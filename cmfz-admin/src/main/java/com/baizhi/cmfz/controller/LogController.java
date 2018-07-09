package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-09 22:26
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService ls;

    @RequestMapping("/showAllByPage")
    @ResponseBody
    public Map<String,Object> showAllByPage(Integer page,Integer rows){
        return ls.queryAllByPage(page, rows);
    }
}
