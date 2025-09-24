package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 根据用户名查询医生信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDoctorDetailByUsername {

    /**
     * 医生id
     */
    private Integer id;

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
     * 医生职称
     */
    private String profashionTitle;

    /**
     * 科室名称
     */
    private String departmentName;

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
