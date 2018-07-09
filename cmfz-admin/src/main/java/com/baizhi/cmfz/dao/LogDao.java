package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-09 20:08
 */
public interface LogDao {

    public Integer insertLog(Log log);


    public List<Log> selectAllByPage(@Param("begin") Integer begin, @Param("rows") Integer rows);

    public Long count();


}
