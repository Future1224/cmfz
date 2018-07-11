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
    public void addGuru(Guru guru) throws Exception{
        Integer i = gd.insertGuru(guru);
        if(i<=0){
            throw new RuntimeException("上师添加失败！");
        }
    }

    @Override
    public void addBulkGuru(List<Guru> gurus)throws Exception {
        Integer i = gd.insertBulkGuru(gurus);
        if(i!=gurus.size()){
            throw new RuntimeException("批量添加上师失败！");
        }
    }

    @Override
    public void removeGuru(String guruId) throws Exception{
        Integer i = gd.deleteGuru(guruId);
        if(i<=0){
            throw new RuntimeException("上师删除失败！");
        }
    }

    @Override
    public void modifyGuru(Guru guru)throws Exception {
        Integer i = gd.updateGuru(guru);
        if(i<=0){
            throw new RuntimeException("上师修改失败！");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Guru queryById(String guruId)throws Exception {
        return gd.selectById(guruId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String,Object> queryLikeName(String guruName, Integer page, Integer rows)throws Exception {
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
    public Map<String,Object> querytAll(Integer page, Integer rows) throws Exception{
        List<Guru> gurus = gd.selectAll((page - 1) * rows, rows);
        Long count = gd.count();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Guru> querytAllNoPage()throws Exception {
        return gd.selectAllNoPage();
    }
}
