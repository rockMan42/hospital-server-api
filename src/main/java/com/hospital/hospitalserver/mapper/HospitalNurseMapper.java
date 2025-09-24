package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.response.GetNurseDetailByUsername;

import com.hospital.hospitalserver.domain.entity.HospitalUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalNurseMapper {

    GetNurseDetailByUsername getNurseDetailByUsername(HospitalUser user);
}
