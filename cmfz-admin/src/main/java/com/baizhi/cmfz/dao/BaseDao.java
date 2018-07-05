package com.baizhi.cmfz.dao;


import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:通用Dao接口，泛型为实际类型
 * @author 赵文朋
 * @create 2018-07-04 14:32
 */
public interface BaseDao<T> {
    public Integer insert(T t);
    public Integer delete(@Param("id") String id);
    public Integer update(T t);
    public T  selectById(@Param("id") String id);
    public List<T> selectAll();
    public Long count();
}
