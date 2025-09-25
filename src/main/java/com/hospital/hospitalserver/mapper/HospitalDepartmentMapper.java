package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateDepartmentReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDepartmentDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDepartmentPageReqDtp;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateDepartmentReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentDetailRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentRespDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalDepartmentMapper {

    /**
     * 新增科室
     */
    void createDepartment(HospitalCreateDepartmentReqDto reqDto);

    /**
     * 查询科室详情
     */
    HospitalGetDepartmentDetailRespDto getDepartmentDetail(HospitalGetDepartmentDetailReqDto reqDto);

    /**
     * 修改科室信息
     */
    void updateDepartment(HospitalUpdateDepartmentReqDto reqDto);

    /**
     * 查询科室列表
     */
    List<HospitalGetDepartmentPageRespDto> getDepartmentPageList(HospitalGetDepartmentPageReqDtp reqDtp);

    /**
     * 查询科室列表总数
     */
    Integer getDepartmentPageListCount(HospitalGetDepartmentPageReqDtp reqDtp);

    /**
     * 获取科室名称列表
     */
    List<HospitalGetDepartmentRespDto> getDepartmentSlimNameList();

    /**
     * 删除科室
     */
    void deleteDepartmentByIds(Integer id);

    /**
     * 获取科室下的医生
     */
    Integer getDepartmentDoctors(Integer id);

}
