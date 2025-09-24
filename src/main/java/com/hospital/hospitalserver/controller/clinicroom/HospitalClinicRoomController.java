package com.hospital.hospitalserver.controller.clinicroom;


import com.hospital.hospitalserver.domain.dto.request.HospitalGetClinicRoomPageReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetClinicRoomPageRespDto;
import com.hospital.hospitalserver.service.HospitalClinicRoomService;
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
public class HospitalClinicRoomController {

    @Autowired
    private HospitalClinicRoomService hospitalClinicRoomService;

    /**
     * 获取所有诊室名称
     * @return
     */
    @PostMapping("/hospital/clinicroom/getClinicRoomPage")
    public Response getClinicRoomSlimNameList(@RequestBody @Validated HospitalGetClinicRoomPageReqDto requestDto) {
        List<HospitalGetClinicRoomPageRespDto> clinicRoomSlimNameList = hospitalClinicRoomService.getClinicRoomSlimNameList(requestDto);
        return Response.success(clinicRoomSlimNameList);
    }
}
