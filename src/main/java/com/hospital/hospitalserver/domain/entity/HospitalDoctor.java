package com.hospital.hospitalserver.domain.entity;

import com.hospital.hospitalserver.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 医生
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDoctor extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 医生姓名
     */
    private String name;

    /**
     * 工号
     */
    private String workId;

    /**
     * 性别：男/女
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 医生职称ID
     */
    private Integer ptId;

    /**
     * 科室ID
     */
    private Integer departmentId;

    /**
     * 专业方向
     */
    private String majorDirect;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 入职日期
     */
    private LocalDate enterDate;

    /**
     * 医生状态：0-在岗（默认），1-休假，2-停职
     */
    private Integer status;

    /**
     * 备注信息
     */
    private String description;
}
