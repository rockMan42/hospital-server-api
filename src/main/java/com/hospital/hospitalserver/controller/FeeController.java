package com.hospital.hospitalserver.controller;

import com.hospital.hospitalserver.domain.dto.request.HospitalAddFeeItemReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalBatchDeleteFeeItemReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeCategoryDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeCategoryPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeItemDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetFeeItemPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateFeeItemReqDto;
import com.hospital.hospitalserver.domain.dto.response.FeeItemsRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeCategoryDetailRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeCategoryListRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetFeeItemDetailRespDto;
import com.hospital.hospitalserver.service.HospitalFeeCategoryService;
import com.hospital.hospitalserver.service.HospitalFeeItemService;
import com.hospital.hospitalserver.util.PageUtils;
import com.hospital.hospitalserver.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class FeeController {

    @Autowired
    private HospitalFeeCategoryService hospitalFeeCategoryService;

    @Autowired
    private HospitalFeeItemService hospitalFeeItemService;

    /**
     * 获取费用类别分页列表
     * @param reqDto 查询条件
     * @return 分页结果
     */
    @PostMapping("/hospital/fee/getFeeCategoryPage")
    public Response getFeeCategoryPageList(@RequestBody @Validated HospitalGetFeeCategoryPageReqDto reqDto) {
        PageUtils pageUtils = hospitalFeeCategoryService.getFeeCategoryPageList(reqDto);
        return Response.success(pageUtils);
    }

    /**
     * 获取费用类别列表（简化版）
     * @return 费用类别列表
     */
    @GetMapping("/hospital/fee/getFeeCategoryList")
    public Response getFeeCategoryList() {
        List<HospitalGetFeeCategoryListRespDto> list = hospitalFeeCategoryService.getFeeCategoryList();
        return Response.success(list);
    }

    /**
     * 获取费用类别详情
     * @param reqDto 查询条件
     * @return 费用类别详情
     */
    @PostMapping("/hospital/fee/getFeeCategoryDetail")
    public Response getFeeCategoryDetail(@RequestBody @Validated HospitalGetFeeCategoryDetailReqDto reqDto) {
        HospitalGetFeeCategoryDetailRespDto detail = hospitalFeeCategoryService.getFeeCategoryDetail(reqDto);
        return Response.success(detail);
    }

    /**
     * 获取费用项目分页列表
     * @param reqDto 查询条件
     * @return 分页结果
     */
    @PostMapping("/hospital/fee/getFeeItemPage")
    public Response getFeeItemPageList(@RequestBody @Validated HospitalGetFeeItemPageReqDto reqDto) {
        PageUtils pageUtils = hospitalFeeItemService.getFeeItemPageList(reqDto);
        return Response.success(pageUtils);
    }

    /**
     * 获取费用项目详情
     * @param reqDto 查询条件
     * @return 费用项目详情
     */
    @PostMapping("/hospital/fee/getFeeItemDetail")
    public Response getFeeItemDetail(@RequestBody @Validated HospitalGetFeeItemDetailReqDto reqDto) {
        HospitalGetFeeItemDetailRespDto detail = hospitalFeeItemService.getFeeItemDetail(reqDto);
        return Response.success(detail);
    }

    /**
     * 添加费用项目
     * @param reqDto 费用项目信息
     * @return 添加结果
     */
    @PostMapping("/hospital/fee/addFeeItem")
    public Response addFeeItem(@RequestBody @Validated HospitalAddFeeItemReqDto reqDto) {
        boolean success = hospitalFeeItemService.addFeeItem(reqDto);
        if (success) {
            return Response.success("添加费用项目成功");
        } else {
            return Response.error("添加费用项目失败");
        }
    }

    /**
     * 更新费用项目
     * @param reqDto 费用项目信息
     * @return 更新结果
     */
    @PostMapping("/hospital/fee/updateFeeItem")
    public Response updateFeeItem(@RequestBody @Validated HospitalUpdateFeeItemReqDto reqDto) {
        boolean success = hospitalFeeItemService.updateFeeItem(reqDto);
        if (success) {
            return Response.success("更新费用项目成功");
        } else {
            return Response.error("更新费用项目失败");
        }
    }

    /**
     * 批量删除费用项目
     * @param reqDto 费用项目ID列表
     * @return 删除结果
     */
    @PostMapping("/hospital/fee/batchDeleteFeeItem")
    public Response batchDeleteFeeItem(@RequestBody @Validated HospitalBatchDeleteFeeItemReqDto reqDto) {
        int deletedCount = hospitalFeeItemService.batchDeleteFeeItem(reqDto);
        if (deletedCount > 0) {
            return Response.success("成功删除 " + deletedCount + " 条费用项目记录");
        } else {
            return Response.error("删除费用项目失败，未找到匹配的记录");
        }
    }

    /**
     * 统计费用类型数量，启用数量，停用数量，今日更新
     * @return
     */
    @GetMapping("/hospital/fee/getFeeItems")
    public Response getFeeItems() {
        FeeItemsRespDto feeItems =  hospitalFeeItemService.getFeeItems();
        return Response.success(feeItems);
    }
}
