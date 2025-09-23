package com.hospital.hospitalserver.mapping;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreatePatientReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetPatientPageRespDto;
import com.hospital.hospitalserver.domain.entity.HospitalPatient;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HospitalPatientMapping {

    HospitalPatient toCreatePatient(HospitalCreatePatientReqDto reqDto);

    List<HospitalGetPatientPageRespDto> toGetPatientRespDto(List<HospitalPatient> patients);
}
