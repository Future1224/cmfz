package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-06 18:06
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService gs;


    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> showAll(Integer page,Integer rows){
        return gs.querytAll(page, rows);
    }

    @RequestMapping("/showById")
    @ResponseBody
    public Guru showById(String guruId){
        return gs.queryById(guruId);
    }

    @RequestMapping("/modifyGuru")
    @ResponseBody
    public Boolean modifyGuru(Guru guru,MultipartFile guruPhotoFile,HttpServletRequest request) throws IOException {
        if(guruPhotoFile.getOriginalFilename()!=null && guruPhotoFile.getOriginalFilename()!=""){
            String realPath = request.getSession().getServletContext().getRealPath("/upload/guruPhoto").replace(request.getContextPath().replace("/","\\"),"");
            int i = guruPhotoFile.getOriginalFilename().lastIndexOf(".");
            String s = guruPhotoFile.getOriginalFilename().substring(i);
            String s1 = UUID.randomUUID().toString().replace("-", "");
            String s2 = s1+s;
            guruPhotoFile.transferTo(new File(realPath,s2));
            guru.setGuruPhoto(s2);
        }
        return gs.modifyGuru(guru);
    }




    @RequestMapping("/addGuru")
    @ResponseBody
    public Boolean addGuru(MultipartFile guruPhotoFile, HttpServletRequest request, Guru guru) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/upload/guruPhoto").replace(request.getContextPath().replace("/","\\"),"");
        int i = guruPhotoFile.getOriginalFilename().lastIndexOf(".");
        String s = guruPhotoFile.getOriginalFilename().substring(i);
        String s1 = UUID.randomUUID().toString().replace("-", "");
        String s2 = s1+s;
        guruPhotoFile.transferTo(new File(realPath,s2));
        guru.setGuruPhoto(s2);
        Boolean flag = gs.addGuru(guru);
        return flag;
    }
}
