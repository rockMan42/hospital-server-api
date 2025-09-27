package com.hospital.hospitalserver.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 新增医生 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalCreateDoctorReqDto {

    /**
     * 医生ID（插入后自动生成）
     */
    private Integer id;

    /**
     * 医生姓名
     */
    @NotNull(message = "医生姓名不能为空")
    private String name;

    /**
     * 工号
     */
    @NotNull(message = "工号不能为空")
    private String workId;

    /**
     * 性别：男/女
     */
    @NotNull(message = "性别不能为空")
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
     * 诊室id
     */
    private Integer clinicRoomId;

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
    private LocalDate enterDate; // 格式（yyyy-MM-dd）

    /**
     * 医生状态：0-在岗（默认），1-休假，2-停职
     */
    private Integer status;

    /**
     * 备注信息
     */
    private String description;

    /**
     * 医生头像
     */
    private String avatar;
}
