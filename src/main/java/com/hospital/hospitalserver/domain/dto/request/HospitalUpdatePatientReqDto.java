package com.hospital.hospitalserver.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改患者信息 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalUpdatePatientReqDto {

    /**
     * 患者ID（必填）
     */
    @NotNull(message = "患者ID不能为空")
    private Integer id;

    /**
     * 就诊卡号（可选）
     */
    private String patientId;

    /**
     * 姓名（可选）
     */
    private String name;

    /**
     * 性别（可选）
     */
    private String gender;

    /**
     * 身份证号（可选）
     */
    private String idCard;

    /**
     * 出生日期（可选）
     */
    private String birthDate;

    /**
     * 电话（可选）
     */
    private String phone;

    /**
     * 地址（可选）
     */
    private String address;

    /**
     * 备注（可选）
     */
    private String remark;
}
