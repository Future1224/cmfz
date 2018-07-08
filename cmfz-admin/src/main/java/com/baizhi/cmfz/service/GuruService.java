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

    public Boolean addGuru(Guru guru);

    public Boolean addBulkGuru(List<Guru> gurus);

    public Boolean removeGuru( String guruId);

    public Boolean modifyGuru (Guru guru);

    public Guru queryById(String guruId);

    public Map<String,Object> queryLikeName(String guruName, Integer page, Integer rows);

    public Map<String,Object>  querytAll(Integer page,Integer rows);
}
