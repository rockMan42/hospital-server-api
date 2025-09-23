package com.hospital.hospitalserver.domain.entity;

import com.hospital.hospitalserver.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 诊室
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalClinicRoom extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 诊室编号
     */
    private String roomNumber;

    /***
     * 科室id
     */
    private Integer departmentId;

    /**
     * 诊室位置
     */
    private String location;

    /**
     * 诊室状态
     */
    private Integer status;

    /**
     * 诊室名称
     */
    private String name;
}
