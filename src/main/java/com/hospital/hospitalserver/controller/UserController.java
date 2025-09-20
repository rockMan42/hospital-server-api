package com.hospital.hospitalserver.controller;

import com.hospital.hospitalserver.entity.UserInfo;
import com.hospital.hospitalserver.service.UserService;
import com.hospital.hospitalserver.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户模块的API请求接口
 * */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 验证用户登录
     * 验证登录的地址： 服务器地址:端口号/user/validateUser
     * */
    @PostMapping("/validateUser")
    public Response vaidateUser(@RequestBody UserInfo user){
        return userService.validateUser(user);
    }
}
