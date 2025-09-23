package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.entity.HospitalUser;
import com.hospital.hospitalserver.enums.ResultCodeEnum;
import com.hospital.hospitalserver.mapper.HospitalUserMapper;
import com.hospital.hospitalserver.util.Response;
import com.hospital.hospitalserver.util.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 用户模块实现类
 * */
@Service
@Slf4j
public class HospitalUserService {

    @Autowired
    HospitalUserMapper userMapper;
    /**
     * 定义方法
     * 用户登录
     * */
    public Response validateUser(HospitalUser user){
        HospitalUser u = userMapper.validateUser(user);
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
