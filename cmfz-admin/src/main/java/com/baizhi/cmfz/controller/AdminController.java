package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.util.NewValidateCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-04 16:12
 */

@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"adminName"})
public class AdminController {
    @Autowired
    private AdminService as;


    /**
     * 描述:
     *
     * @return java.lang.String
     * @author future_zwp
     * @Date 2018/7/9 12:03
     * @Param [request, model]
     */
    @RequestMapping("/getCookie")
    public String getCookie(HttpServletRequest request, Model model) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("adminName")) {
                    model.addAttribute("adminName", cookie.getValue());
                }
                if (cookie.getName().equals("adminPassword")) {
                    model.addAttribute("adminPassword", cookie.getValue());
                }
            }
        }
        return "login";


    }


    /**
     * 描述:
     *
     * @return void
     * @author future_zwp
     * @Date 2018/7/9 12:04
     * @Param [response, session]
     */
    @RequestMapping("/newCode")
    public void newCode(HttpServletResponse response, HttpSession session) throws Exception {
        NewValidateCodeUtil newCode = new NewValidateCodeUtil(110, 35, 4, 5);
        String vcode = newCode.getCode();
        session.setAttribute("vcode", vcode);
        newCode.write(response.getOutputStream());
    }


    /**
     * 描述:
     *
     * @return java.lang.String
     * @author future_zwp
     * @Date 2018/7/5 9:07
     * @Param [adminName, adminPassword, remember, code, model, session, response]
     */
    @RequestMapping("/login")
    public String login(String adminName, String adminPassword, String[] remember, String code, Model model, HttpSession session, HttpServletResponse response) throws Exception {
        if (code != null && !code.equals("")) {                                  //判断验证码是否为空
            String vcode = (String) session.getAttribute("vcode");         //session中取出验证码
            if (code.equalsIgnoreCase(vcode)) {                               //判断验证码是否正确

                Subject subject = SecurityUtils.getSubject();
                try {
                    subject.login(new UsernamePasswordToken(adminName, adminPassword));
//                    System.out.println("====================================================================");
//                    System.out.println(subject.hasRole("root"));
//                    System.out.println(subject.hasRole("admin"));
//                    System.out.println(subject.hasRole("admin1"));
//                    System.out.println(subject.isPermitted("guru:add"));
//                    System.out.println(subject.isPermitted("guru:query"));
//                    System.out.println(subject.isPermitted("guru:bulk"));
//                    System.out.println("=========================================================================");
                    if (remember != null) {
                        Cookie adminName1 = new Cookie("adminName", adminName);//存储cookie作为记住我数据
                        adminName1.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(adminName1);
                        Cookie adminPassword1 = new Cookie("adminPassword", adminPassword);
                        adminPassword1.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(adminPassword1);
                    } else {                                                          //未选中记住我情况下将cookie设置为空串
                        Cookie adminName2 = new Cookie("adminName", "");
                        adminName2.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(adminName2);
                        Cookie adminPassword2 = new Cookie("adminPassword", "");
                        adminName2.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(adminPassword2);
                    }
                    model.addAttribute("adminName",adminName);
                    return "main/main";
                } catch (AuthenticationException e) {
                    e.printStackTrace();
                    System.out.println("=========================账号或密码错误===========================");
                    return "redirect:getCookie";
                }
            }
        }
        return "redirect:getCookie";
    }

}


//                    Admin admin = as.login(adminName, adminPassword);           //调用业务登录方法
//                    if(admin!=null){                                            //业务方法返回值不为空则登录成功
//                        if(remember!=null){
//                            Cookie adminName1 = new Cookie("adminName", adminName);//存储cookie作为记住我数据
//                            adminName1.setMaxAge(60*60*24*7);
//                            response.addCookie(adminName1);
//                            Cookie adminPassword1 = new Cookie("adminPassword", adminPassword);
//                            adminName1.setMaxAge(60*60*24*7);
//                            response.addCookie(adminPassword1);
//                        }else{                                                          //未选中记住我情况下将cookie设置为空串
//                            Cookie adminName2 = new Cookie("adminName", "");
//                            adminName2.setMaxAge(60*60*24*7);
//                            response.addCookie(adminName2);
//                            Cookie adminPassword2 = new Cookie("adminPassword", "");
//                            adminName2.setMaxAge(60*60*24*7);
//                            response.addCookie(adminPassword2);
//                        }
//                        model.addAttribute("admin",admin);                     //存admin到session中
//                        return "main/main";
//                    }
//                }
//
//            }
//
//                return "redirect:getCookie";
//    }
//}
