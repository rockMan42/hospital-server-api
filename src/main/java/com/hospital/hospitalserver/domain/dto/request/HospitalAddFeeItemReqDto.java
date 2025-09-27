package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 添加费用项目 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalAddFeeItemReqDto {

    /**
     * 项目编码
     */
    @NotBlank(message = "项目编码不能为空")
    private String itemCode;

    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空")
    private String itemName;

    /**
     * 费用类别ID
     */
    @NotNull(message = "费用类别ID不能为空")
    private Long categoryId;

    /**
     * 标准价格
     */
    @NotNull(message = "标准价格不能为空")
    private BigDecimal standardPrice;

    /**
     * 医保价格
     */
    private BigDecimal insurancePrice;

    /**
     * 成本价格
     */
    private BigDecimal costPrice;

    /**
     * 计价单位
     */
    @NotBlank(message = "计价单位不能为空")
    private String unit;

    /**
     * 医保类别 A甲类 B乙类 C丙类 self自费
     */
    private String insuranceType = "B";

    /**
     * 适用科室ID数组
     */
    private String departmentIds;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 是否启用
     */
    private Integer isActive = 1;
}
