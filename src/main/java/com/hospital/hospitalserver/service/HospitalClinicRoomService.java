package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetClinicRoomPageReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetClinicRoomPageRespDto;
import com.hospital.hospitalserver.mapper.HospitalClinicRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalClinicRoomService {

    @Autowired
    private HospitalClinicRoomMapper hospitalClinicRoomMapper;

    /**
     * 获取诊室列表(名称)
     * @return
     */
    public List<HospitalGetClinicRoomPageRespDto> getClinicRoomSlimNameList(HospitalGetClinicRoomPageReqDto requestDto) {
        return hospitalClinicRoomMapper.getClinicRoomSlimNameList(requestDto);
    }
}
