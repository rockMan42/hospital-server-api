package com.hospital.hospitalserver.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新增患者 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalCreatePatientReqDto {

    /**
     *  姓名
     */
    @NotNull(message = "姓名不能为空")
    private String name;

    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    private String gender;

    /**
     * 就诊卡号
     */
    @NotNull(message = "就诊卡号不能为空")
    private String idCard;

    /**
     *  出生日期
     */
    private String birthDate;

    /**
     * 手机号
     */
    private String phone;

    /**
     *  地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;
}
