package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 查询医生完整分页列表 respDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetDoctorFullPageRespDto {

    /**
     * 医生id
     */
    private Integer id;

    /**
     * 工号
     */
    private String workId;

    /**
     * 医生姓名
     */
    private String name;

    /**
     * 职称ID
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
     * 电话
     */
    private String phone;

    /**
     * 入职时间
     */
    private Date enterDate;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 描述
     */
    private String description;

    /**
     * 医生头像
     */
    private String avatar;
}
