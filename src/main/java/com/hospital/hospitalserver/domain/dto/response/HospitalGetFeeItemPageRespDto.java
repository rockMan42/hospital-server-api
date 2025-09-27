package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查询费用项目分页列表 respDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetFeeItemPageRespDto {

    /**
     * 项目ID
     */
    private Long id;

    /**
     * 项目编码
     */
    private String itemCode;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 费用类别ID
     */
    private Long categoryId;

    /**
     * 费用类别名称
     */
    private String categoryName;

    /**
     * 标准价格
     */
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
    private String unit;

    /**
     * 医保类别 A甲类 B乙类 C丙类 self自费
     */
    private String insuranceType;

    /**
     * 医保类别名称
     */
    private String insuranceTypeName;

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
    private Integer isActive;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
