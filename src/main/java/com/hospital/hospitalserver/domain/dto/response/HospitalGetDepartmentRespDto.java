package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询科室列表(只要名称和id) reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetDepartmentRespDto {
    /**
     * 科室id
     */
    private Integer departmentId;

    /**
     * 科室名称
     */
    private String name;
}
