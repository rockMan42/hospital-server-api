package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * 查询费用项目详情 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetFeeItemDetailReqDto {

    /**
     * 费用项目ID
     */
    @NotNull(message = "费用项目ID不能为空")
    private Long id;
}
