package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * 查询医生详情 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetDoctorDetailReqDto {

    /**
     * 医生id
     */
    @NotNull(message = "医生ID不能为空")
    private Integer id;
}
