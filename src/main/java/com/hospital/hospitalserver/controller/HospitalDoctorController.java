package com.hospital.hospitalserver.controller;

import com.hospital.hospitalserver.domain.dto.request.*;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorFullPageRespDto;
import com.hospital.hospitalserver.service.HospitalDoctorService;
import com.hospital.hospitalserver.util.PageUtils;
import com.hospital.hospitalserver.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class HospitalDoctorController {

    @Autowired
    private HospitalDoctorService hospitalDoctorService;

    /**
     * 新增医生
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/doctor/createDoctor")
    public Response createDoctor(@RequestBody @Validated HospitalCreateDoctorReqDto reqDto) {
        return hospitalDoctorService.createDoctor(reqDto);
    }

    /**
     * 获取医生列表
     * @param reqDtp
     * @return
     */
    @PostMapping("/hospital/doctor/getDoctorPage")
    public Response getDoctorPageList(@RequestBody @Validated HospitalGetDoctorPageReqDto reqDtp) {
        List<HospitalGetDoctorPageRespDto> doctorPageList = hospitalDoctorService.getDoctorPageList(reqDtp);
        return Response.success(doctorPageList);
    }

    /**
     * 获取医生完整分页列表
     * @param reqDtp
     * @return
     */
    @PostMapping("/hospital/doctor/getDoctorFullPage")
    public Response getDoctorFullPageList(@RequestBody @Validated HospitalGetDoctorFullPageReqDto reqDtp) {
        PageUtils pageUtils = hospitalDoctorService.getDoctorFullPageList(reqDtp);
        return Response.success(pageUtils);
    }

    /**
     * 查询医生详情
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/doctor/getDoctorDetail")
    public Response getDoctorDetail(@RequestBody @Validated HospitalGetDoctorDetailReqDto reqDto) {
        HospitalGetDoctorFullPageRespDto doctorDetail = hospitalDoctorService.getDoctorDetail(reqDto);
        return Response.success(doctorDetail);
    }

    /**
     * 修改医生信息
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/doctor/updateDoctor")
    public Response updateDoctor(@RequestBody @Validated HospitalUpdateDoctorReqDto reqDto) {
        return hospitalDoctorService.updateDoctor(reqDto);
    }

    @PostMapping("/hospital/doctor/deleteDoctor")
    public Response deleteDoctor(@RequestBody @Validated HospitalDeleteDoctorReqDto reqDto) {
        return hospitalDoctorService.deleteDoctorByIds(reqDto.getIds());
    }
}
