package com.hospital.hospitalserver.domain.dto.request;

import lombok.Data;

import java.util.List;

/**
 * 删除科室 reqDto
 */
@Data
public class HospitalDeleteDepartmentReqDto {

    /**
     * 科室id列表
     */
    private List<Integer> ids;
}
