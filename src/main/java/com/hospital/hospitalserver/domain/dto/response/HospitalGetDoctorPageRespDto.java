package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询医生列表 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetDoctorPageRespDto {

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 医生姓名
     */
    private String name;
}
