package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-09 20:18
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {


    @Autowired
    private LogDao ld;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String, Object> queryAllByPage(Integer page, Integer rows) {


        List<Log> logs = ld.selectAllByPage((page - 1) * rows, rows);
        Long count = ld.count();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows",logs);
        return map;
    }
}
