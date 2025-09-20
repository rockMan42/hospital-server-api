package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户模块的方法接口
 * */
@Mapper
public interface UserMapper {
    /**
     * 定义方法
     * 用户登录
     * */
    UserInfo validateUser(UserInfo user);
}
