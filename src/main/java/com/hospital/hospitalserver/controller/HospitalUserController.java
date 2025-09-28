package com.hospital.hospitalserver.controller;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateUser;
import com.hospital.hospitalserver.domain.entity.HospitalUser;
import com.hospital.hospitalserver.service.HospitalUserService;
import com.hospital.hospitalserver.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户模块的API请求接口
 * */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class HospitalUserController {

    @Autowired
    HospitalUserService userService;
    /**
     * 验证用户登录
     * 验证登录的地址： 服务器地址:端口号/user/validateUser
     * */
    @PostMapping("/login")
    public Response login(@RequestBody HospitalUser user){
        return userService.login(user);
    }

    /**
     * 创建用户
     * @param createUser
     * @return
     */
    @PostMapping("/createUser")
    public Response createUser(@RequestBody @Validated HospitalCreateUser createUser){
        int id =  userService.createUser(createUser);
        return Response.success(id);
    }
}
