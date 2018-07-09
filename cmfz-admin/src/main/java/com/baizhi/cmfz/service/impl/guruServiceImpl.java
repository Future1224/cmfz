package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:上师业务层
 *
 * @author future_zwp
 * @create 2018-07-06 17:56
 */
@Service
@Transactional
public class guruServiceImpl implements GuruService {


    @Autowired
    private GuruDao gd;

    @Override
    public Boolean addGuru(Guru guru) {
        Integer i = gd.insertGuru(guru);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean addBulkGuru(List<Guru> gurus) {
        Integer i = gd.insertBulkGuru(gurus);
        if(i== gurus.size()){
            return true;
        }
        return false;
    }

    @Override
    public Boolean removeGuru(String guruId) {
        Integer i = gd.deleteGuru(guruId);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean modifyGuru(Guru guru) {
        Integer i = gd.updateGuru(guru);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Guru queryById(String guruId) {
        return gd.selectById(guruId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String,Object> queryLikeName(String guruName, Integer page, Integer rows) {
        String s = "%" + guruName + "%";
        List<Guru> gurus = gd.selectLikeName(s, (page - 1) * rows, rows);
        Long count = gd.countLikeName(s);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String,Object> querytAll(Integer page, Integer rows) {
        List<Guru> gurus = gd.selectAll((page - 1) * rows, rows);
        Long count = gd.count();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Guru> querytAllNoPage() {
        return gd.selectAllNoPage();
    }
}
