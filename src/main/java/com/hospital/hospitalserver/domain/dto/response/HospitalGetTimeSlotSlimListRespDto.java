package com.hospital.hospitalserver.domain.dto.response;

import lombok.Data;

/**
 * 获取班次时间（部分）列表 resp dto
 */
@Data
public class HospitalGetTimeSlotSlimListRespDto {

    /**
     * 班次时间ID
     */
    private Integer id;

    /**
     * 班次时间名称
     */
    private String slotName;

    /**
     * 班次开始时间
     */
    private String startTime;

    /**
     * 班次结束时间
     */
    private String endTime;
}
