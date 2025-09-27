package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * 查询费用类别详情 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetFeeCategoryDetailReqDto {

    /**
     * 费用类别ID
     */
    @NotNull(message = "费用类别ID不能为空")
    private Long id;
}
