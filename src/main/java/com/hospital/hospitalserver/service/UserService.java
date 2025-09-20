package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.entity.UserInfo;
import com.hospital.hospitalserver.enums.ResultCodeEnum;
import com.hospital.hospitalserver.mapper.UserMapper;
import com.hospital.hospitalserver.util.Response;
import com.hospital.hospitalserver.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 用户模块实现类
 * */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    /**
     * 定义方法
     * 用户登录
     * */
    public Response validateUser(UserInfo user){
        UserInfo u = userMapper.validateUser(user);
        if(u!=null){
            //登录成功
            String token = TokenUtils.sign(user);
            HashMap<String,Object> hs = new HashMap<>();
            hs.put("user",u);
            hs.put("token",token);
            return Response.success(ResultCodeEnum.LOGIN_SUCCESS,hs);
        }else{
            //登录失败
            return Response.error(ResultCodeEnum.LOGIN_ERROR);
        }
    }
}
