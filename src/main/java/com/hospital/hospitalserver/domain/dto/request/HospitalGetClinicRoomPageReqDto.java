package com.hospital.hospitalserver.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取真是列表（名称） reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetClinicRoomPageReqDto {

    /**
     * 科室id
     */
    private Integer departmentId;
}
