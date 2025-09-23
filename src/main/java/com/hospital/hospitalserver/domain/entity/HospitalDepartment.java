package com.hospital.hospitalserver.domain.entity;

import com.hospital.hospitalserver.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * 科室
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDepartment extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 科室名称
     */
    private String name;

    /**
     * 科室编码
     */
    private String code;

    /**
     * 科室描述
     */
    private String description;

    /**
     * 科室类型ID
     */
    private Integer dcId;

    /**
     * 科室主任医生ID
     */
    private Integer doctorId;

    /**
     * 科室主任职称
     */
    private String jobTitle;

    /**
     * 科室联系电话
     */
    private String phone;


    /**
     * 科室成立时间
     */
    private LocalDate establishedTime;

    /**
     * 科室状态：0-正常，1-停用
     */
    private Integer status;
}
