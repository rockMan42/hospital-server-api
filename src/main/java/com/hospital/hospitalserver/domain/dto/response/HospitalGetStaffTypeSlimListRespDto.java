package com.hospital.hospitalserver.domain.dto.response;

import lombok.Data;

/**
 * 获取人员类型（部分）列表 resp dto
 */
@Data
public class HospitalGetStaffTypeSlimListRespDto {

    /**
     * 人员类型ID
     */
    private Integer id;

    /**
     * 人员类型名称
     */
    private String typeName;

}
