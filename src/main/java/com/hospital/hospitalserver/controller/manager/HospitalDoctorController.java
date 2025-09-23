package com.hospital.hospitalserver.controller.manager;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorPageReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorPageRespDto;
import com.hospital.hospitalserver.service.HospitalDoctorService;
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
     * 获取医生列表
     * @param reqDtp
     * @return
     */
    @PostMapping("/hospital/doctor/getDoctorPage")
    public Response getDoctorPageList(@RequestBody @Validated HospitalGetDoctorPageReqDto reqDtp) {
        List<HospitalGetDoctorPageRespDto> doctorPageList = hospitalDoctorService.getDoctorPageList(reqDtp);
        return Response.success(doctorPageList);
    }
}
