package com.hospital.hospitalserver.controller.manager;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreatePatientReqDto;
import com.hospital.hospitalserver.service.HospitalPatientService;
import com.hospital.hospitalserver.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HospitalPatientController {

    @Autowired
    private HospitalPatientService hospitalPatientService;

    /**
     * 新增患者
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/patient/createPatient")
    public Response createPatient(@RequestBody @Validated HospitalCreatePatientReqDto reqDto) {
        hospitalPatientService.createPatient(reqDto);
        return Response.success();
    }

    /**
     * 獲取患者分頁列表
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/patient/getPatientPage")
    public Response getPatientPage(@RequestBody @Validated com.hospital.hospitalserver.domain.dto.request.HospitalGetPatientReqDto reqDto) {
        return Response.success(hospitalPatientService.getPatientPage(reqDto));
    }
}
