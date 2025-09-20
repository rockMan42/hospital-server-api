package com.hospital.hospitalserver.util;

import com.hospital.hospitalserver.enums.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * 工具类
 * 负责将控制器层得到的数据传递给前端
 * 统一响应体
 *
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private int code;      // 状态码
    private String msg; // 消息
    private Object data;    // 对象数据

    /**
     * 成功响应静态方法 重载方法
     * 不带参数
     * @return Response
     */
    public static Response success(){
        return new Response(ResultCodeEnum.SUCCESS.getCode(),ResultCodeEnum.SUCCESS.getMessage(),null);
    }

    /**
     * 成功响应静态方法 重载方法
     * 带参数
     * @return Response
     */
    public static Response success(Object data){
        return new Response(ResultCodeEnum.SUCCESS.getCode(),ResultCodeEnum.SUCCESS.getMessage(),data);
    }

    /**
     * 登录成功
     */
    public static Response success(ResultCodeEnum resultCodeEnum,Object data){
        return  new Response(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), data);
    }
    /**
     * 错误响应静态方法 重载方法
     * @return Response
     */
    public static Response error(){
        return new Response(ResultCodeEnum.ERROR.getCode(),ResultCodeEnum.ERROR.getMessage(),null);
    }

    /**
     * 错误响应静态方法 重载方法
     * @return Response
     */
    public static Response error(Integer code, String message){
        return new Response(code,message,null);
    }

    /**
     * 错误响应静态方法（系统异常） 重载方法
     * @return
     * /
     */
    public static Response error(Object  data){
        return new Response(ResultCodeEnum.SYSTEM_ERROR.getCode(), ResultCodeEnum.SYSTEM_ERROR.getMessage(), data);
    }

    /**
     * 登录失败
     */
    public static Response error(ResultCodeEnum resultCodeEnum){
        return new Response(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), null);
    }
}