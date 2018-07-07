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
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-05 21:13
 */
@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService ps;


    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> showAll(Integer page,Integer rows){
        return ps.queryAll(page, rows);
    }




    @RequestMapping("/showById")
    @ResponseBody
    public Picture showById(String pictureId){
        return ps.queryById(pictureId);
    }

    @RequestMapping("/modifyPicture")
    @ResponseBody
    public Boolean modifyPicture(Picture picture){
        return ps.modifyPicture(picture);
    }

    @RequestMapping("/uploadPicture")
    @ResponseBody
    public Boolean uploadPicture(MultipartFile pictureFile, HttpServletRequest request, Picture picture) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/upload/picture").replace(request.getContextPath().replace("/","\\"),"");
        int i = pictureFile.getOriginalFilename().lastIndexOf(".");
        String s = pictureFile.getOriginalFilename().substring(i);
        String s1 = UUID.randomUUID().toString().replace("-", "");
        String s2 = s1+s;
        pictureFile.transferTo(new File(realPath,s2));
        picture.setPicturePath(s2);
        picture.setPictureDate(new Date());
        Boolean flag = ps.addPicture(picture);
        return flag;
    }
}
