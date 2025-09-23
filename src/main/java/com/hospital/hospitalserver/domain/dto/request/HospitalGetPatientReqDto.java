package com.hospital.hospitalserver.domain.dto.request;

import com.hospital.hospitalserver.domain.PageAndSizeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询患者列表 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetPatientReqDto extends PageAndSizeDto {

    /**
     *  姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     *  手机号码
     */
    private String phone;

    /**
     * 开始
     */
    private Integer start;
}
