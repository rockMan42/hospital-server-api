package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.response.GetNurseDetailByUsername;

import com.hospital.hospitalserver.domain.entity.HospitalUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalNurseMapper {

    /**
     * 根据用户名查询护士详情
     */
    GetNurseDetailByUsername getNurseDetailByUsername(HospitalUser user);
}
