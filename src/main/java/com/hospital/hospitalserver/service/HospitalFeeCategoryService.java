package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeCategoryDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeCategoryPageReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeCategoryDetailRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeCategoryListRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeCategoryPageRespDto;
import com.hospital.hospitalserver.mapper.HospitalFeeCategoryMapper;
import com.hospital.hospitalserver.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 费用类别 Service
 */
@Service
@Slf4j
public class HospitalFeeCategoryService {

    @Autowired
    private HospitalFeeCategoryMapper hospitalFeeCategoryMapper;

    /**
     * 获取费用类别分页列表
     * @param reqDto 查询条件
     * @return 分页结果
     */
    public PageUtils getFeeCategoryPageList(HospitalGetFeeCategoryPageReqDto reqDto) {
        List<HospitalGetFeeCategoryPageRespDto> list = null;
        reqDto.setStart((reqDto.getPage() - 1) * reqDto.getSize());

        Integer count = hospitalFeeCategoryMapper.getFeeCategoryPageListCount(reqDto);
        if (count != null && count > 0) {
            list = hospitalFeeCategoryMapper.getFeeCategoryPageList(reqDto);
        }

        return new PageUtils(list, count != null ? count : 0, reqDto.getPage(), reqDto.getSize());
    }

    /**
     * 获取费用类别列表（简化版）
     * @return 费用类别列表
     */
    public List<HospitalGetFeeCategoryListRespDto> getFeeCategoryList() {
        return hospitalFeeCategoryMapper.getFeeCategoryList();
    }

    /**
     * 获取费用类别详情
     * @param reqDto 查询条件
     * @return 费用类别详情
     */
    public HospitalGetFeeCategoryDetailRespDto getFeeCategoryDetail(HospitalGetFeeCategoryDetailReqDto reqDto) {
        return hospitalFeeCategoryMapper.getFeeCategoryDetail(reqDto);
    }
}
