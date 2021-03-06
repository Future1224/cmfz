package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 描述:上师模块控制层
 *
 * @author future_zwp
 * @create 2018-07-06 18:06
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService gs;

    /**
     * 描述:根据页数和每页显示的条数查询所有上师信息
     *
     * @author future_zwp
     * @Date 2018/7/7 20:54
     * @Param [page, rows]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> showAll(Integer page,Integer rows)throws Exception{
        return gs.querytAll(page, rows);
    }


    /**
     * 描述:分页展示根据上师法名模糊查询的结果
     *
     * @author future_zwp
     * @Date 2018/7/7 20:55
     * @Param [like, page, rows]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("/showLikeName")
    @ResponseBody
    public Map<String,Object> showLikeName(String like,Integer page,Integer rows)throws Exception{
        return gs.queryLikeName(like,page,rows);
    }


    /**
     * 描述:根据上师Id查询上师信息
     *
     * @author future_zwp
     * @Date 2018/7/7 20:56
     * @Param [guruId]
     * @return com.baizhi.cmfz.entity.Guru
     */
    @RequestMapping("/showById")
    @ResponseBody
    public Guru showById(String guruId)throws Exception{
        return gs.queryById(guruId);
    }


    /**
     * 描述:修改上师信息（用户不重新上传头像的话就不修改头像）
     *
     * @author future_zwp
     * @Date 2018/7/7 20:56
     * @Param [guru, guruPhotoFile, request]
     * @return java.lang.Boolean
     */
    @RequestMapping("/modifyGuru")
    @ResponseBody
    public Boolean modifyGuru(Guru guru,MultipartFile guruPhotoFile,HttpServletRequest request) throws Exception {
        if(guruPhotoFile.getOriginalFilename()!=null && guruPhotoFile.getOriginalFilename()!=""){          //判断是否有上传的头像文件
            String realPath = request.getSession().getServletContext().getRealPath("/upload/guruPhoto").replace(request.getContextPath().replace("/","\\"),"");
            int i = guruPhotoFile.getOriginalFilename().lastIndexOf(".");
            String s = guruPhotoFile.getOriginalFilename().substring(i);
            String s1 = UUID.randomUUID().toString().replace("-", "");
            String s2 = s1+s;
            guruPhotoFile.transferTo(new File(realPath,s2));
            guru.setGuruPhoto(s2);
        }
        try {
            gs.modifyGuru(guru);
        } catch (Exception e) {
            return false;
        }
        return true;
    }



    /**
     * 描述:添加上师信息(将上师上传的头像信息存储到/upload/guruPhoto文件夹)
     *
     * @author future_zwp
     * @Date 2018/7/7 20:58
     * @Param [guruPhotoFile, request, guru]
     * @return java.lang.Boolean
     */
    @RequestMapping("/addGuru")
    @ResponseBody
    public Boolean addGuru(MultipartFile guruPhotoFile, HttpServletRequest request, Guru guru) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/upload/guruPhoto").replace(request.getContextPath().replace("/","\\"),"");
        int i = guruPhotoFile.getOriginalFilename().lastIndexOf(".");
        String s = guruPhotoFile.getOriginalFilename().substring(i);
        String s1 = UUID.randomUUID().toString().replace("-", "");
        String s2 = s1+s;
        guruPhotoFile.transferTo(new File(realPath,s2));
        guru.setGuruPhoto(s2);
        try {
            gs.addGuru(guru);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 描述:使用Excel文件批量添加上师信息
     *
     * @author future_zwp
     * @Date 2018/7/7 20:59
     * @Param [guruExeclFile]
     * @return java.lang.Boolean
     */
    @RequestMapping("/addBulkGuru")
    @ResponseBody
    public  Boolean addBulkGuru(MultipartFile guruExeclFile) throws Exception {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);//表格头占几行
        params.setHeadRows(1);//列头占几行
        List<Guru> gurus = ExcelImportUtil.importExcel(guruExeclFile.getInputStream(), Guru.class, params);
        try {
            gs.addBulkGuru(gurus);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }




    @RequestMapping("/searchAll")
    @ResponseBody
    public List<Guru> searchAll()throws Exception {
        return  gs.querytAllNoPage();
    }



    @RequestMapping("/exportGuru")
    public void exportGuru(HttpServletResponse response)throws Exception{
        List<Guru> gurus = gs.querytAllNoPage();
        // Excel文件
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("持明法洲上师信息表", "上师信息表"), Guru.class, gurus);
        // 文件下载 设置响应头
        // 注意：响应头 默认使用的编码格式iso-8859-1
        String fileName = new String("持明法洲上师信息表.xls".getBytes(), "iso-8859-1");
        response.setContentType("application/vnd.ms-excel"); //响应类型  text/html  application/json
        response.setHeader("content-disposition","attachment;fileName="+fileName);
        ServletOutputStream out = response.getOutputStream();
        // 导出 文件下载的方式
        workbook.write(out);
        out.close();


    }




}
