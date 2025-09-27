package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.HospitalAddFeeItemReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalBatchDeleteFeeItemReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeItemDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeItemPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateFeeItemReqDto;
import com.hospital.hospitalserver.domain.dto.response.FeeItemsRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeItemDetailRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeItemPageRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 费用项目 Mapper
 */
@Mapper
public interface HospitalFeeItemMapper {

    /**
     * 获取费用项目分页列表
     * @param reqDto 查询条件
     * @return 费用项目列表
     */
    List<HospitalGetFeeItemPageRespDto> getFeeItemPageList(HospitalGetFeeItemPageReqDto reqDto);

    /**
     * 获取费用项目分页列表总数
     * @param reqDto 查询条件
     * @return 总数
     */
    Integer getFeeItemPageListCount(HospitalGetFeeItemPageReqDto reqDto);

    /**
     * 获取费用项目详情
     * @param reqDto 查询条件
     * @return 费用项目详情
     */
    HospitalGetFeeItemDetailRespDto getFeeItemDetail(HospitalGetFeeItemDetailReqDto reqDto);

    /**
     * 添加费用项目
     * @param reqDto 费用项目信息
     * @return 影响行数
     */
    Integer addFeeItem(HospitalAddFeeItemReqDto reqDto);

    /**
     * 更新费用项目
     * @param reqDto 费用项目信息
     * @return 影响行数
     */
    Integer updateFeeItem(HospitalUpdateFeeItemReqDto reqDto);

    /**
     * 批量删除费用项目
     * @param reqDto 费用项目ID列表
     * @return 影响行数
     */
    Integer batchDeleteFeeItem(HospitalBatchDeleteFeeItemReqDto reqDto);

    /**
     * 统计费用类型数量，启用数量，停用数量，今日更新
     * @return
     */
    FeeItemsRespDto getFeeItems();
}
