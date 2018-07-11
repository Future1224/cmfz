package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.Map;


/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-05 20:26
 */

public interface PictureService {

    public void addPicture(Picture picture)throws Exception;

    public void removePicture(String pictureId)throws Exception;

    public void modifyPicture(Picture picture)throws Exception;

    public Picture queryById(String pictureId)throws Exception;

    public Map<String,Object> queryAll(Integer page,Integer rows)throws Exception;

}
