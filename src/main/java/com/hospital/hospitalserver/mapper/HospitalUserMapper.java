package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.entity.HospitalUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户模块的方法接口
 * */
@Mapper
public interface HospitalUserMapper {
    /**
     * 定义方法
     * 用户登录
     * */
    HospitalUser validateUser(HospitalUser user);
}
