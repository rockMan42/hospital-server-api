package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询医生列表 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetDoctorPageReqDto {

    /**
     * 诊室id
     */
    private Integer clinicRoomId;

    /***
     * 科室id
     */
    private Integer departmentId;
}
