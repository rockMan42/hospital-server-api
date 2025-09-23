package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询患者列表 respDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetPatientPageRespDto {
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
