package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-06 16:55
 */
public interface GuruDao {
    public Integer insertGuru(Guru guru);

    public Integer deleteGuru(@Param("guruId") String guruId);

    public Integer updateGuru (Guru guru);

    public Guru selectById(@Param("guruId") String guruId);

    public List<Guru> selectLikeName(@Param("guruName") String guruName,@Param("begin") Integer begin,@Param("rows") Integer rows);

    public Long count();

    public Long countLikeName(@Param("guruName") String guruName);

    public List<Guru> selectAll(@Param("begin") Integer begin,@Param("rows") Integer rows);
}
