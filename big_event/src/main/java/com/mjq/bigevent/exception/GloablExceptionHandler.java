package com.mjq.bigevent.exception;

import com.mjq.bigevent.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloablExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result hanlerException(Exception e){
        e.printStackTrace();
        return  Result.error(StringUtils.hasLength(e.getMessage())?e.getMessage():"操作失败");
    }
}
