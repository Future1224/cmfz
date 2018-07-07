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

    public Boolean addPicture(Picture picture);

    public Boolean removePicture(String pictureId);

    public Boolean modifyPicture(Picture picture);

    public Picture queryById(String pictureId);

    public Map<String,Object> queryAll(Integer page,Integer rows);

}
