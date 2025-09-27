package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 查询费用类别分页列表 respDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetFeeCategoryPageRespDto {

    /**
     * 类别ID
     */
    private Long id;

    /**
     * 类别编码
     */
    private String categoryCode;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * 类别类型 1挂号费 2检查费 3治疗费 4药品费 5材料费 6手术费 7住院费
     */
    private Integer categoryType;

    /**
     * 类别类型名称
     */
    private String categoryTypeName;

    /**
     * 类别描述
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
}
