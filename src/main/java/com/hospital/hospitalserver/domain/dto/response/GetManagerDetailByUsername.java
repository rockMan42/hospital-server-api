package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 根据用户名查询管理员信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetManagerDetailByUsername {
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
     * 医生职称
     */
    private String profashionTitle;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 联系电话
     */
    private String phone;

}
