package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 描述:轮播图控制器
 *
 * @author future_zwp
 * @create 2018-07-05 21:13
 */
@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService ps;

    /**
     * 描述:分页展示所有轮播图片
     *
     * @author future_zwp
     * @Date 2018/7/7 21:02
     * @Param [page, rows]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> showAll(Integer page,Integer rows)throws Exception{
        return ps.queryAll(page, rows);
    }



    /**
     * 描述:根据轮播图Id查询轮播图信息
     *
     * @author future_zwp
     * @Date 2018/7/7 21:02
     * @Param [pictureId]
     * @return com.baizhi.cmfz.entity.Picture
     */
    @RequestMapping("/showById")
    @ResponseBody
    public Picture showById(String pictureId)throws Exception{
        return ps.queryById(pictureId);
    }



    /**
     * 描述:修改轮播图
     *
     * @author future_zwp
     * @Date 2018/7/7 21:03
     * @Param [picture]
     * @return java.lang.Boolean
     */
    @RequestMapping("/modifyPicture")
    @ResponseBody
    public Boolean modifyPicture(Picture picture)throws Exception{
        try {
            ps.modifyPicture(picture);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 描述: 添加轮播图（并将轮播图片上传到upload/picture文件夹）
     *
     * @author future_zwp
     * @Date 2018/7/7 21:03
     * @Param [pictureFile, request, picture]
     * @return java.lang.Boolean
     */
    @RequestMapping("/uploadPicture")
    @ResponseBody
    public Boolean uploadPicture(MultipartFile pictureFile, HttpServletRequest request, Picture picture) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/upload/picture").replace(request.getContextPath().replace("/","\\"),"");
        int i = pictureFile.getOriginalFilename().lastIndexOf(".");
        String s = pictureFile.getOriginalFilename().substring(i);
        String s1 = UUID.randomUUID().toString().replace("-", "");
        String s2 = s1+s;
        pictureFile.transferTo(new File(realPath,s2));
        picture.setPicturePath(s2);
        picture.setPictureDate(new Date());
        ps.addPicture(picture);
        return true;

    }
}
