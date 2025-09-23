package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 删除医生 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDeleteDoctorReqDto {

    /**
     * 医生ids
     */
    List<Integer> ids;
}
