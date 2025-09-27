package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeCategoryDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeCategoryPageReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeCategoryDetailRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeCategoryListRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeCategoryPageRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 费用类别 Mapper
 */
@Mapper
public interface HospitalFeeCategoryMapper {

    /**
     * 获取费用类别分页列表
     * @param reqDto 查询条件
     * @return 费用类别列表
     */
    List<HospitalGetFeeCategoryPageRespDto> getFeeCategoryPageList(HospitalGetFeeCategoryPageReqDto reqDto);

    /**
     * 获取费用类别分页列表总数
     * @param reqDto 查询条件
     * @return 总数
     */
    Integer getFeeCategoryPageListCount(HospitalGetFeeCategoryPageReqDto reqDto);

    /**
     * 获取费用类别列表（简化版）
     * @return 费用类别列表
     */
    List<HospitalGetFeeCategoryListRespDto> getFeeCategoryList();

    /**
     * 获取费用类别详情
     * @param reqDto 查询条件
     * @return 费用类别详情
     */
    HospitalGetFeeCategoryDetailRespDto getFeeCategoryDetail(HospitalGetFeeCategoryDetailReqDto reqDto);
}
