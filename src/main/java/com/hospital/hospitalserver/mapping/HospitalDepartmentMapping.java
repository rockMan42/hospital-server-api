package com.hospital.hospitalserver.mapping;

import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentPageRespDto;
import com.hospital.hospitalserver.domain.entity.HospitalDepartment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HospitalDepartmentMapping {

    /**
     * 将部门列表转换为部门分页响应列表
     */
    List<HospitalGetDepartmentPageRespDto> toGetDepartmentPageRespDtpList(List<HospitalDepartment> list);
}
