package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-05 19:54
 */
public interface PictureDao {
    /**
     * 描述:插入一条轮播图片信息到数据库
     *
     * @author future_zwp
     * @Date 2018/7/7 21:05
     * @Param [picture]
     * @return java.lang.Integer
     */
    public Integer insertPicture(Picture picture);

    /**
     * 描述:根据轮播图Id删除轮播图信息
     *
     * @author future_zwp
     * @Date 2018/7/7 21:08
     * @Param [pictureId]
     * @return java.lang.Integer
     */
    public Integer deletePicture(@Param("pictureId") String pictureId);


    /**
     * 描述:修改轮播图信息
     *
     * @author future_zwp
     * @Date 2018/7/7 21:09
     * @Param [picture]
     * @return java.lang.Integer
     */
    public Integer updatePicture(Picture picture);

    /**
     * 描述:根据轮播图Id查询轮播图信息
     *
     * @author future_zwp
     * @Date 2018/7/7 21:09
     * @Param [pictureId]
     * @return com.baizhi.cmfz.entity.Picture
     */
    public Picture selectById(@Param("pictureId") String pictureId);


    /**
     * 描述:查询数据库轮播图的总条数
     *
     * @author future_zwp
     * @Date 2018/7/7 21:10
     * @Param []
     * @return java.lang.Long
     */
    public Long count();



    /**
     * 描述:分页查询轮播图数据
     *
     * @author future_zwp
     * @Date 2018/7/7 21:10
     * @Param [begin, rows]
     * @return java.util.List<com.baizhi.cmfz.entity.Picture>
     */
    public List<Picture> selectAll(@Param("begin") Integer begin,@Param("rows") Integer rows);
}
