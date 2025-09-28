package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.response.HospitalGetStaffTypeSlimListRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetTimeSlotSlimListRespDto;
import com.hospital.hospitalserver.domain.entity.HospitalStaffType;
import com.hospital.hospitalserver.domain.entity.HospitalTimeSlot;
import com.hospital.hospitalserver.mapper.HospitalScheduleMapper;
import com.hospital.hospitalserver.mapping.HospitalScheduleMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalScheduleService {
    @Autowired
    private HospitalScheduleMapper hospitalScheduleMapper;

    @Autowired
    private HospitalScheduleMapping hospitalScheduleMapping;
    /**
     * 获取人员类型（部分）列表
     *
     * @return
     */
    public List<HospitalGetStaffTypeSlimListRespDto> getScheduleSlimList() {
        List<HospitalStaffType> staffTypeSlimList = hospitalScheduleMapper.getStaffTypeSlimList();
        return hospitalScheduleMapping.toGetStaffTypeSlimListRespDto(staffTypeSlimList);
    }
    /**
     * 获取排班信息(部分)列表
     *
     * @return
     */
    public List<HospitalGetTimeSlotSlimListRespDto> getTimeSlotSlimList() {
        List<HospitalTimeSlot> timeSlotSlimList = hospitalScheduleMapper.getTimeSlotSlimList();
        return hospitalScheduleMapping.toGetTimeSlotSlimListRespDto(timeSlotSlimList);
    }
}
