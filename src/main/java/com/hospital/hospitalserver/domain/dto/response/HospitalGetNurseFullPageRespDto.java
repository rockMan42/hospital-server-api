package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 查询护士完整分页列表 respDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetNurseFullPageRespDto {

    /**
     * 护士id
     */
    private Integer id;

    /**
     * 工号
     */
    private String workId;

    /**
     * 护士姓名
     */
    private String name;

    /**
     * 职称名称
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
     * 状态 0在岗1休假2停职
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
}
