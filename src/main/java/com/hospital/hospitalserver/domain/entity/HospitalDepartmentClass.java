package com.hospital.hospitalserver.domain.entity;

import com.hospital.hospitalserver.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 科室类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDepartmentClass extends BaseDomain implements Serializable {
    /**
     * 科室类型名称
     */
    private String departmentClassName;
}
