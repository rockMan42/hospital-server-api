package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * 查询科室详情 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetDepartmentDetailReqDto {

    /**
     * 科室id
     */
    @NotNull(message = "科室ID不能为空")
    private Integer id;
}
