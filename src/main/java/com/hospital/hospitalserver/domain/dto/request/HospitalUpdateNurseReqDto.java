package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * 修改护士信息 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalUpdateNurseReqDto {

    /**
     * 护士ID
     */
    @NotNull(message = "护士ID不能为空")
    private Integer id;

    /**
     * 护士姓名
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
     * 护士职称ID
     */
    private Integer nptId;

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
     * 护士状态：0-在岗（默认），1-休假，2-停职
     */
    private Integer status;

    /**
     * 备注信息
     */
    private String description;
}
