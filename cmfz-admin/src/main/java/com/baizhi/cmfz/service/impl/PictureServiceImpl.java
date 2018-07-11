package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:轮播图业务层
 *
 * @author future_zwp
 * @create 2018-07-05 21:01
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pd;

    /**
     * 描述:
     *
     * @author future_zwp
     * @Date 2018/7/5 21:07
     * @Param [picture]
     * @return java.lang.Boolean
     */
    @Override
    public void addPicture(Picture picture)throws Exception {
        Integer i = pd.insertPicture(picture);
        if(i<=0){
            throw new RuntimeException("轮播图添加失败！");
        }
    }


    /**
     * 描述:
     *
     * @author future_zwp
     * @Date 2018/7/5 21:07
     * @Param [pictureId]
     * @return java.lang.Boolean
     */
    @Override
    public void removePicture(String pictureId)throws Exception {
        Integer i = pd.deletePicture(pictureId);
        if(i<=0){
            throw new RuntimeException("轮播图删除失败！");
        }
    }



    /**
     * 描述:
     *
     * @author future_zwp
     * @Date 2018/7/5 21:07
     * @Param [picture]
     * @return java.lang.Boolean
     */
    @Override
    public void modifyPicture(Picture picture)throws Exception {
        Integer i = pd.updatePicture(picture);
        if(i<=0){
            throw new RuntimeException("轮播图修改失败！");
        }
    }



    /**
     * 描述:
     *
     * @author future_zwp
     * @Date 2018/7/5 21:07
     * @Param [pictureId]
     * @return com.baizhi.cmfz.entity.Picture
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Picture queryById(String pictureId)throws Exception {
        return pd.selectById(pictureId);
    }


    /**
     * 描述:
     *
     * @author future_zwp
     * @Date 2018/7/5 21:07
     * @Param [page, rows]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String, Object> queryAll(Integer page, Integer rows)throws Exception {
        List<Picture> pictures = pd.selectAll((page - 1) * rows, rows);
        Long count = pd.count();
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("total", count);
        map.put("rows", pictures);
        return map;
    }
}
