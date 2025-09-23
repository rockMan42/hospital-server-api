package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetPatientReqDto;
import com.hospital.hospitalserver.domain.entity.HospitalPatient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalPatientMapper {

    /**
     * 新增患者
     * @param patient
     */
    void createPatient(HospitalPatient patient);

    /**
     * 查询患者
     *
     * @param reqDto
     * @return
     */
    List<HospitalPatient> getPatientPage(HospitalGetPatientReqDto reqDto);
    /**
     * 获取患者数量
     *
     * @param reqDto
     * @return
     */
    Integer getPatientCount(HospitalGetPatientReqDto reqDto);


}
