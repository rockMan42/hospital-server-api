package com.hospital.hospitalserver.domain.entity;

import com.hospital.hospitalserver.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * 患者
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HospitalPatient extends BaseDomain {
    /**
     * 就诊卡号
     */
    private String patientId;
    /**
     *  姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 身份证号
     */
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
