package com.hospital.hospitalserver.mapping;

import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentPageRespDto;
import com.hospital.hospitalserver.domain.entity.HospitalDepartment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HospitalDepartmentMapping {

    List<HospitalGetDepartmentPageRespDto> toGetDepartmentPageRespDtpList(List<HospitalDepartment> list);
}
