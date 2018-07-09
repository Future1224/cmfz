package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.TextResult;
import com.baizhi.cmfz.service.ArticleService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-09 8:28
 */
@Controller
@RequestMapping("/article")
public class ArticleController {


    @Autowired
    private ArticleService as;

    @RequestMapping("/uploadArticlePicture")
    @ResponseBody
    public TextResult uploadArticlePicture(@RequestParam("articlePictureFile") MultipartFile[] file, HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath("/upload/articlePicture").replace(request.getContextPath().replace("/", "\\"), "");
        TextResult result = new TextResult();
        result.setErrno(1);
        if(file!=null&&file.length>0){
            List<String> data = new ArrayList<String>();
            for (MultipartFile multipartFile : file) {
                String s = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
                String s2 = UUID.randomUUID().toString().replace("-", "")+"."+s;
                try {
                    multipartFile.transferTo(new File(realPath,s2));
                    data.add(request.getContextPath()+"/upload/articlePicture/"+s2);
                    result.setErrno(0);
                    result.setData(data);
                } catch (IOException e) {
                    result.setErrno(1);
                    e.printStackTrace();
                }
            }
        }
            return result;
    }



    @RequestMapping("/addArticle")
    @ResponseBody
    public String addArticle(Article article){
        System.out.println(article);
        if (article.getGuru().getGuruId().equals("--请选择--")){
            return "noMasterError";
        }
        article.setArticleDate(new Date());
        Boolean flag = as.addArticle(article);
        if(flag){
            return "ok";
        }
        return "error";
    }
}
