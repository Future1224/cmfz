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
    /**
     * 描述: 插入一条上师信息
     *       
     * @author future_zwp
     * @Date 2018/7/7 21:13
     * @Param
     * @return 
     */
    public Integer insertGuru(Guru guru);

    /**
     * 描述:批量插入上师信息
     *
     * @author future_zwp
     * @Date 2018/7/7 21:14
     * @Param [gurus]
     * @return java.lang.Integer
     */
    public Integer insertBulkGuru(@Param("gurus") List<Guru> gurus);

    /**
     * 描述:根据上师id删除上师信息
     *
     * @author future_zwp
     * @Date 2018/7/7 21:14
     * @Param [guruId]
     * @return java.lang.Integer
     */
    public Integer deleteGuru(@Param("guruId") String guruId);

    /**
     * 描述:修改上师信息
     *
     * @author future_zwp
     * @Date 2018/7/7 21:15
     * @Param [guru]
     * @return java.lang.Integer
     */
    public Integer updateGuru (Guru guru);


    /**
     * 描述:根据上师Id查询上师信息
     *
     * @author future_zwp
     * @Date 2018/7/7 21:15
     * @Param [guruId]
     * @return com.baizhi.cmfz.entity.Guru
     */
    public Guru selectById(@Param("guruId") String guruId);


    /**
     * 描述:根据上市法名模糊查询上师信息    并分页
     *
     * @author future_zwp
     * @Date 2018/7/7 21:16
     * @Param [guruName, begin, rows]
     * @return java.util.List<com.baizhi.cmfz.entity.Guru>
     */
    public List<Guru> selectLikeName(@Param("guruName") String guruName,@Param("begin") Integer begin,@Param("rows") Integer rows);
    /**
     * 描述:查询上师表总条数
     *
     * @author future_zwp
     * @Date 2018/7/7 21:17
     * @Param []
     * @return java.lang.Long
     */
    public Long count();



    /**
     * 描述:法名模糊查询上市表条数
     *
     * @author future_zwp
     * @Date 2018/7/7 21:18
     * @Param [guruName]
     * @return java.lang.Long
     */
    public Long countLikeName(@Param("guruName") String guruName);


    /**
     * 描述:分页查询上师表
     *
     * @author future_zwp
     * @Date 2018/7/7 21:18
     * @Param [begin, rows]
     * @return java.util.List<com.baizhi.cmfz.entity.Guru>
     */
    public List<Guru> selectAll(@Param("begin") Integer begin,@Param("rows") Integer rows);


    /**
     * 描述: 不分页查询全部上师信息表
     *
     * @author future_zwp
     * @Date 2018/7/9 13:40
     * @Param []
     * @return java.util.List<com.baizhi.cmfz.entity.Guru>
     */
    public List<Guru> selectAllNoPage();

}
