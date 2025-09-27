package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalAddFeeItemReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalBatchDeleteFeeItemReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeItemDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeItemPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateFeeItemReqDto;
import com.hospital.hospitalserver.domain.dto.response.FeeItemsRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeItemDetailRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeItemPageRespDto;
import com.hospital.hospitalserver.mapper.HospitalFeeItemMapper;
import com.hospital.hospitalserver.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 费用项目 Service
 */
@Service
@Slf4j
public class HospitalFeeItemService {

    @Autowired
    private HospitalFeeItemMapper hospitalFeeItemMapper;

    /**
     * 获取费用项目分页列表
     * @param reqDto 查询条件
     * @return 分页结果
     */
    public PageUtils getFeeItemPageList(HospitalGetFeeItemPageReqDto reqDto) {
        List<HospitalGetFeeItemPageRespDto> list = null;
        reqDto.setStart((reqDto.getPage() - 1) * reqDto.getSize());

        Integer count = hospitalFeeItemMapper.getFeeItemPageListCount(reqDto);
        if (count != null && count > 0) {
            list = hospitalFeeItemMapper.getFeeItemPageList(reqDto);
        }

        return new PageUtils(list, count != null ? count : 0, reqDto.getPage(), reqDto.getSize());
    }

    /**
     * 获取费用项目详情
     * @param reqDto 查询条件
     * @return 费用项目详情
     */
    public HospitalGetFeeItemDetailRespDto getFeeItemDetail(HospitalGetFeeItemDetailReqDto reqDto) {
        return hospitalFeeItemMapper.getFeeItemDetail(reqDto);
    }

    /**
     * 添加费用项目
     * @param reqDto 费用项目信息
     * @return 是否添加成功
     */
    @Transactional
    public boolean addFeeItem(HospitalAddFeeItemReqDto reqDto) {
        try {
            Integer result = hospitalFeeItemMapper.addFeeItem(reqDto);
            return result != null && result > 0;
        } catch (Exception e) {
            log.error("添加费用项目失败", e);
            throw new RuntimeException("添加费用项目失败: " + e.getMessage());
        }
    }

    /**
     * 更新费用项目
     * @param reqDto 费用项目信息
     * @return 是否更新成功
     */
    @Transactional
    public boolean updateFeeItem(HospitalUpdateFeeItemReqDto reqDto) {
        try {
            Integer result = hospitalFeeItemMapper.updateFeeItem(reqDto);
            return result != null && result > 0;
        } catch (Exception e) {
            log.error("更新费用项目失败", e);
            throw new RuntimeException("更新费用项目失败: " + e.getMessage());
        }
    }

    /**
     * 批量删除费用项目
     * @param reqDto 费用项目ID列表
     * @return 删除的记录数
     */
    @Transactional
    public int batchDeleteFeeItem(HospitalBatchDeleteFeeItemReqDto reqDto) {
        try {
            if (reqDto.getIds() == null || reqDto.getIds().isEmpty()) {
                throw new RuntimeException("删除的费用项目ID列表不能为空");
            }
            Integer result = hospitalFeeItemMapper.batchDeleteFeeItem(reqDto);
            return result != null ? result : 0;
        } catch (Exception e) {
            log.error("批量删除费用项目失败", e);
            throw new RuntimeException("批量删除费用项目失败: " + e.getMessage());
        }
    }

    /**
     * 统计费用类型数量，启用数量，停用数量，今日更新
     * @return
     */
    public FeeItemsRespDto getFeeItems() {
        return hospitalFeeItemMapper.getFeeItems();
    }
}
