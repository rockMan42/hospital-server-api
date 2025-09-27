package com.hospital.hospitalserver.domain.dto.request;

import com.hospital.hospitalserver.domain.PageAndSizeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 查询费用类别分页列表 reqDto
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetFeeCategoryPageReqDto extends PageAndSizeDto {

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
     * 是否启用
     */
    private Integer isActive;

    /**
     * 开始位置（用于分页）
     */
    private Integer start;
}
