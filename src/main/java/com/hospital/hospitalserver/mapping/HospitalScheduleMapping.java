package com.hospital.hospitalserver.mapping;

import com.hospital.hospitalserver.domain.dto.response.HospitalGetStaffTypeSlimListRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetTimeSlotSlimListRespDto;
import com.hospital.hospitalserver.domain.entity.HospitalStaffType;
import com.hospital.hospitalserver.domain.entity.HospitalTimeSlot;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HospitalScheduleMapping {

    List<HospitalGetStaffTypeSlimListRespDto> toGetStaffTypeSlimListRespDto(List<HospitalStaffType> staffTypes);

    List<HospitalGetTimeSlotSlimListRespDto> toGetTimeSlotSlimListRespDto(List<HospitalTimeSlot> timeSlots);
}
