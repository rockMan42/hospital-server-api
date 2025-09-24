package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.response.GetManagerDetailByUsername;
import com.hospital.hospitalserver.domain.entity.HospitalUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalManagerMapper {

    GetManagerDetailByUsername getManagerDetailByUsername(HospitalUser user);
}
