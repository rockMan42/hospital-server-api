package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorPageReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorPageRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalDoctorMapper {

    /**
     * 查询医生列表
     */
    List<HospitalGetDoctorPageRespDto> getDoctorPageList(HospitalGetDoctorPageReqDto reqDtp);
}
