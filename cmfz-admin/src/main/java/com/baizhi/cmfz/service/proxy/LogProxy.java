package com.baizhi.cmfz.service.proxy;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-09 20:28
 */
@Component
@Aspect
public class LogProxy {

    @Autowired
    private LogDao ld;


//    @Autowired
//    private HttpSession session;

//    @Pointcut("execution(* com.baizhi.cmfz.service.*.add*(..)) || execution(* com.baizhi.cmfz.service.*.remove*(..)) || execution(* com.baizhi.cmfz.service.*.modify*(..))")
//    public void myPointut(){}

    //@Around("myPointut()")
    @Around("execution(* com.baizhi.cmfz.service.impl.*.add*(..)) || execution(* com.baizhi.cmfz.service.impl.*.remove*(..)) || execution(* com.baizhi.cmfz.service.impl.*.modify*(..))")
    @Transactional
    public Object logAround(ProceedingJoinPoint joinPoint){

        Log log = new Log();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String adminName = (String) session.getAttribute("adminName");
        if (adminName!=null){
            log.setAdminName(adminName);
        }


        log.setLogDate(new Date());


        String simpleName = joinPoint.getSignature().getDeclaringType().getSimpleName();//获取目标方法所属类的简单对象名字XXXService
        log.setResource(simpleName.replace("Service",""));


        String methodName = joinPoint.getSignature().getName();//获取目标方法的名字
        log.setAction(methodName);


        StringBuilder stringBuilder = new StringBuilder();
        Object[] args = joinPoint.getArgs();//获取目标方法的参数
        if(args!=null&&args.length>0){
            for (Object arg : args) {
                stringBuilder.append(arg.toString()).append(";");
            }
            log.setMessage(stringBuilder.toString());
        }



        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
            log.setResult("success");
            ld.insertLog(log);
        } catch (Throwable throwable) {
            log.setResult("error");
            ld.insertLog(log);
            throwable.printStackTrace();
        }
        return proceed;
    }




}
