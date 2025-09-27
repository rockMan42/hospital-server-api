package com.hospital.hospitalserver.mapping;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateDoctorReqDto;
import com.hospital.hospitalserver.domain.entity.HospitalDoctor;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HospitalDoctorMapping {

    /**
     * 将创建医生请求转换为医生实体
     * @param reqDto
     * @return
     */
    HospitalDoctor toCreateDoctor(HospitalCreateDoctorReqDto reqDto);
}
