package com.hospital.hospitalserver.exception;

import com.hospital.hospitalserver.util.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.hospital.hospitalserver.controller")
public class GlobalExceptionHandler {

    /**
     * 捕获/处理业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public static Response handleCustomException(CustomException e){
        return Response.error(e.getCode(), e.getMessage());
    }

    /**
     * 捕获/处理系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public static Response handleException(Exception e){
        return Response.error(e);
    }
}
