package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-09 20:16
 */
public interface LogService {

    public Map<String,Object> queryAllByPage(Integer page, Integer rows);
}
