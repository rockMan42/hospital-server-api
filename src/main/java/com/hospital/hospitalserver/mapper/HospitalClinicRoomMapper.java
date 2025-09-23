package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateDoctorReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetClinicRoomPageReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetClinicRoomPageRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalClinicRoomMapper {

    /**
     * 获取诊室列表（名称）
     */
    List<HospitalGetClinicRoomPageRespDto> getClinicRoomSlimNameList(HospitalGetClinicRoomPageReqDto requestDto);

    /**
     * 绑定医生与诊室
     */
    void bindDoctorAndClinicRoom(HospitalCreateDoctorReqDto requestDto);

    /**
     * 更新医生的诊室绑定关系
     */
    void updateDoctorClinicRoomBinding(Integer doctorId, Integer clinicRoomId);

    void unBindDoctorAndClinicRoom(List<Integer> ids);
}
