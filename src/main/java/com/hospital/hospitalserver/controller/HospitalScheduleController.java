package com.hospital.hospitalserver.controller;

import com.hospital.hospitalserver.domain.dto.response.HospitalGetStaffTypeSlimListRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetTimeSlotSlimListRespDto;
import com.hospital.hospitalserver.service.HospitalScheduleService;
import com.hospital.hospitalserver.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class HospitalScheduleController {

    @Autowired
    private HospitalScheduleService hospitalScheduleService;
    /**
     * 获取人员类型（部分）列表
     */
    @GetMapping("/hospital/schedule/getStaffTypeSlimList")
    public Response getStaffTypeSlimList() {
        List<HospitalGetStaffTypeSlimListRespDto> scheduleSlimList = hospitalScheduleService.getScheduleSlimList();
        return Response.success(scheduleSlimList);
    }

    /**
     * 获取排班信息(部分)列表
     */
    @GetMapping("/hospital/schedule/getScheduleSlimList")
    public Response getScheduleSlimList() {
        List<HospitalGetTimeSlotSlimListRespDto> timeSlotSlimList = hospitalScheduleService.getTimeSlotSlimList();
        return Response.success(timeSlotSlimList);
    }
}
