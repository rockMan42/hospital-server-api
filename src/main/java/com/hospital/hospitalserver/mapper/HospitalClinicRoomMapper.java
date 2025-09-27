package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.*;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetClinicRoomDetailRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetClinicRoomPageRespDto;
import com.hospital.hospitalserver.domain.entity.HospitalClinicRoom;
import org.apache.ibatis.annotations.Mapper;
import com.hospital.hospitalserver.domain.dto.request.HospitalCreateDoctorReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalCreateNurseReqDto;
import java.util.List;

@Mapper
public interface HospitalClinicRoomMapper {

    /**
     * 获取诊室列表（名称）
     */
    List<HospitalGetClinicRoomPageRespDto> getClinicRoomSlimNameList();

    /**
     * 获取诊室分页列表
     */
    List<HospitalGetClinicRoomDetailRespDto> getClinicRoomPageList(HospitalGetClinicRoomPageReqDto reqDto);

    /**
     * 获取诊室总数
     */
    Integer getClinicRoomCount(HospitalGetClinicRoomPageReqDto reqDto);

    /**
     * 查询诊室详情
     */
    HospitalGetClinicRoomDetailRespDto getClinicRoomDetail(HospitalGetClinicRoomDetailReqDto reqDto);

    /**
     * 新增诊室
     */
    Integer createClinicRoom(HospitalClinicRoom clinicRoom);

    /**
     * 更新诊室信息
     */
    Integer updateClinicRoom(HospitalClinicRoom clinicRoom);

    /**
     * 批量删除诊室
     */
    Integer deleteClinicRoomByIds(List<Integer> ids);

    /**
     * 检查诊室编号是否存在
     */
    Integer checkRoomNumberExists(String roomNumber);

    /**
     * 检查诊室编号是否存在（排除自己）
     */
    Integer checkRoomNumberExistsExcludeSelf(String roomNumber, Integer id);

    /**
     * 检查诊室是否有医生关联
     */
    Integer checkDoctorsInClinicRooms(Integer id);

    /**
     * 绑定医生与诊室
     */
    Integer bindDoctorAndClinicRoom(HospitalCreateDoctorReqDto requestDto);

    /**
     * 更新医生的诊室绑定关系
     */
    Integer updateDoctorClinicRoomBinding(Integer doctorId, Integer clinicRoomId);

    /**
     * 解绑医生与诊室
     */
    Integer unBindDoctorAndClinicRoom(List<Integer> ids);

    /**
     * 绑定护士与诊室
     */
    Integer bindNurseAndClinicRoom(HospitalCreateNurseReqDto requestDto);

    /**
     * 更新护士的诊室绑定关系
     */
    Integer updateNurseClinicRoomBinding(Integer nurseId, Integer clinicRoomId);

    /**
     * 解绑护士与诊室
     */
    Integer unBindNurseAndClinicRoom(List<Integer> ids);
}
