package com.hospital.hospitalserver.domain.entity;

import com.hospital.hospitalserver.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 员工类型实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalStaffType extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 员工类型编码
     */
    private String typeCode;

    /**
     * 员工类型名称
     */
    private String typeName;

    /***
     * 员工类型描述
     */
    private String description;

    /**
     * 员工类型状态：0-正常，1-禁用 是否激活
     */
    private Integer isActive;
}
