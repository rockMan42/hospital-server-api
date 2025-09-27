package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * 查询护士详情 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetNurseDetailReqDto {

    /**
     * 护士id
     */
    @NotNull(message = "护士ID不能为空")
    private Integer id;
}
