package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * 查询科室详情 respDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetDepartmentDetailRespDto {

    /**
     * 科室id
     */
    private Integer id;

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
     * 科室类型名称
     */
    private String departmentClassName;

    /**
     * 科室主任医生姓名
     */
    private String doctorName;

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

    /**
     * 医生数量
     */
    private Integer doctorCount;

    /**
     * 诊室数量
     */
    private Integer clinicRoomCount;
}
