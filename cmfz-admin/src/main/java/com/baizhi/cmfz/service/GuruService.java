package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;

import java.util.List;
import java.util.Map;

/**
 * 描述:上师业务接口
 *
 * @author future_zwp
 * @create 2018-07-06 17:52
 */
public interface GuruService {

    public void addGuru(Guru guru)throws Exception;

    public void addBulkGuru(List<Guru> gurus)throws Exception;

    public void removeGuru( String guruId)throws Exception;

    public void modifyGuru (Guru guru)throws Exception;

    public Guru queryById(String guruId)throws Exception;

    public Map<String,Object> queryLikeName(String guruName, Integer page, Integer rows)throws Exception;

    public Map<String,Object>  querytAll(Integer page,Integer rows)throws Exception;


    public List<Guru>  querytAllNoPage()throws Exception;
}
