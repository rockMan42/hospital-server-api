package com.hospital.hospitalserver.domain.dto.request;

import com.hospital.hospitalserver.domain.PageAndSizeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 查询费用项目分页列表 reqDto
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetFeeItemPageReqDto extends PageAndSizeDto {

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 费用类别ID
     */
    private Long categoryId;

    /**
     * 适用科室ID数组
     */
    private String departmentIds;

    /**
     * 是否启用
     */
    private Integer isActive;

    /**
     * 开始位置（用于分页）
     */
    private Integer start;
}
