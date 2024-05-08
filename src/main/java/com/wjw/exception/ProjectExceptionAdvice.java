package com.wjw.exception;

import com.wjw.vo.Code;
import com.wjw.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){
        //导出项目日志，发邮件给运维人员，发消息给开发人员等
        return new Result(e.getCode(),e.getMessage(),null);
    }

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){
        return new Result(e.getCode(),e.getMessage(),null);
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        return new Result(Code.ERROR,"项目出错了",null);
    }
}
