package com.hospital.hospitalserver.controller;

import com.hospital.hospitalserver.util.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class HomeController {
    /**
     * 请求方法
     * */
    @RequestMapping(value = "/getTest", method = RequestMethod.POST, produces = "application/json; utf-8")
    public Response getTest(){
        return new Response(200,"消息",null);
    }


}
