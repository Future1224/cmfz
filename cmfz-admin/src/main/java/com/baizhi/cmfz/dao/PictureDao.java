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

    public Integer insertPicture(Picture picture);

    public Integer deletePicture(@Param("pictureId") String pictureId);

    public Integer updatePicture(Picture picture);

    public Picture selectById(@Param("pictureId") String pictureId);

    public Long count();

    public List<Picture> selectAll(@Param("begin") Integer begin,@Param("rows") Integer rows);
}
