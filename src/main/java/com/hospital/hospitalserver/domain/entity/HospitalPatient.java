package com.hospital.hospitalserver.domain.entity;

import com.hospital.hospitalserver.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 患者
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalPatient extends BaseDomain {
    /**
     *  姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 就诊卡号
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
