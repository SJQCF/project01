package com.sjqcf.exception;

import com.sjqcf.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AllException {
    @ExceptionHandler
    public Result handle(Exception e){
        log.error("出现异常:",e);
        return Result.error("服务器异常");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.info("出现重复异常",e);
        String s = e.getMessage();
        int i = s.indexOf("Duplicate entry");
        String errmsg = s.substring(i);
        String[] ss = errmsg.split(" ");
        return Result.error(ss[2] + "已存在");
    }

    @ExceptionHandler
    public Result handleMyException(MyException e){
        log.info("出现自定义异常",e);
        return Result.error(e.getMessage());
    }
}
