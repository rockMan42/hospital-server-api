package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * 查询患者详情 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetPatientDetailReqDto {

    /**
     * 患者id
     */
    @NotNull(message = "患者ID不能为空")
    private Integer id;
}
