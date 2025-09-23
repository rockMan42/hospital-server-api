package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetDepartmentPageReqDtp;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentRespDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalDepartmentMapper {

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
}
