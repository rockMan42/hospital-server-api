package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorPageReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorPageRespDto;
import com.hospital.hospitalserver.mapper.HospitalDoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalDoctorService {

    @Autowired
    private HospitalDoctorMapper hospitalDoctorMapper;

    /**
     * 获取医生列表
     * @param reqDtp
     * @return
     */
    public List<HospitalGetDoctorPageRespDto> getDoctorPageList(HospitalGetDoctorPageReqDto reqDtp) {
        return hospitalDoctorMapper.getDoctorPageList(reqDtp);
    }
}
