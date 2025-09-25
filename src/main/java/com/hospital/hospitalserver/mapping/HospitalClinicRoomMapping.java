package com.hospital.hospitalserver.mapping;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateClinicRoomReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateClinicRoomReqDto;
import com.hospital.hospitalserver.domain.entity.HospitalClinicRoom;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HospitalClinicRoomMapping {

    HospitalClinicRoom toHospitalClinicRoom(HospitalCreateClinicRoomReqDto reqDto);

    HospitalClinicRoom toHospitalUpdateClinicRoom(HospitalUpdateClinicRoomReqDto reqDto);
}
