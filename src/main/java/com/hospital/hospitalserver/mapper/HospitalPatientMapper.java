package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetPatientReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetPatientDetailReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetPatientPageRespDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdatePatientReqDto;
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

    /**
     * 查询患者详情
     * @param reqDto
     * @return
     */
    HospitalGetPatientPageRespDto getPatientDetail(HospitalGetPatientDetailReqDto reqDto);

    /**
     * 更新患者信息
     * @param reqDto
     * @return 受影响行数
     */
    Integer updatePatient(HospitalUpdatePatientReqDto reqDto);

    /**
     * 批量删除患者
     * @param ids 患者ID集合
     */
    Integer deletePatientByIds(List<Integer> ids);


}
