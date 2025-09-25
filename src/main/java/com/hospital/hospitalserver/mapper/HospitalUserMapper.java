package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.BaseUser;
import com.hospital.hospitalserver.domain.dto.request.HospitalCreateUser;
import com.hospital.hospitalserver.domain.entity.HospitalUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户模块的方法接口
 * */
@Mapper
public interface HospitalUserMapper {
    /**
     * 校验用户是否存在
     * */
    HospitalUser validateUserExist(HospitalUser user);

    /**
     * 获取用户信息
     * @param user
     * @return
     */
    BaseUser getBaseUserByUsername(HospitalUser user);

    /**
     * 创建用户
     * @param createUser
     * @return
     */
    Integer createUser(HospitalCreateUser createUser);

    /**
     * 校验用户是否存在
     * @param createUser
     * @return
     */
    HospitalUser validateUserExistByUsername(HospitalCreateUser createUser);
}
