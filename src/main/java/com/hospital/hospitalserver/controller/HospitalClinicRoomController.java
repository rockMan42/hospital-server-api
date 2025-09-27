package com.hospital.hospitalserver.controller;

import com.hospital.hospitalserver.domain.dto.request.*;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetClinicRoomPageRespDto;
import com.hospital.hospitalserver.service.HospitalClinicRoomService;
import com.hospital.hospitalserver.util.PageUtils;
import com.hospital.hospitalserver.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class HospitalClinicRoomController {

    @Autowired
    private HospitalClinicRoomService hospitalClinicRoomService;

    /**
     * 获取所有诊室名称
     * @return
     */
    @GetMapping("/hospital/clinicroom/getClinicRoomPage")
    public Response getClinicRoomSlimNameList() {
        List<HospitalGetClinicRoomPageRespDto> clinicRoomSlimNameList = hospitalClinicRoomService.getClinicRoomSlimNameList();
        return Response.success(clinicRoomSlimNameList);
    }

    /**
     * 新增诊室
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/clinicroom/createClinicRoom")
    public Response createClinicRoom(@RequestBody @Validated HospitalCreateClinicRoomReqDto reqDto) {
        return hospitalClinicRoomService.createClinicRoom(reqDto);
    }

    /**
     * 获取诊室分页列表
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/clinicroom/getClinicRoomPageList")
    public Response getClinicRoomPageList(@RequestBody @Validated HospitalGetClinicRoomPageReqDto reqDto) {
        PageUtils pageUtils = hospitalClinicRoomService.getClinicRoomPageList(reqDto);
        return Response.success(pageUtils);
    }

    /**
     * 查询诊室详情
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/clinicroom/getClinicRoomDetail")
    public Response getClinicRoomDetail(@RequestBody @Validated HospitalGetClinicRoomDetailReqDto reqDto) {
        return hospitalClinicRoomService.getClinicRoomDetail(reqDto);
    }

    /**
     * 修改诊室信息
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/clinicroom/updateClinicRoom")
    public Response updateClinicRoom(@RequestBody @Validated HospitalUpdateClinicRoomReqDto reqDto) {
        return hospitalClinicRoomService.updateClinicRoom(reqDto);
    }

    /**
     * 删除诊室
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/clinicroom/deleteClinicRoom")
    public Response deleteClinicRoom(@RequestBody @Validated HospitalDeleteClinicRoomReqDto reqDto) {
        return hospitalClinicRoomService.deleteClinicRoomByIds(reqDto.getIds());
    }
}
