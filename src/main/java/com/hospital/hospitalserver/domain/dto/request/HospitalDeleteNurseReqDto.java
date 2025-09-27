package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 删除护士 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDeleteNurseReqDto {

    /**
     * 护士ids
     */
    List<Integer> ids;
}
