package com.dyyhub.controller.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springMVC的异常处理器
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有异常信息
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        //记录日志
        //通知运维
        //通知开发
        //通知用户
        ex.printStackTrace();
        return new Result("服务器故障，请联系管理员");
    }
}
