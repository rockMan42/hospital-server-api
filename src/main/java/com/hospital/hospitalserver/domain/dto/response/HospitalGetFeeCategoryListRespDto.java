package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询费用类别列表 respDto（简化版）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetFeeCategoryListRespDto {

    /**
     * 类别ID
     */
    private Long id;

    /**
     * 类别名称
     */
    private String categoryName;
}
