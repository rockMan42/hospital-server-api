package com.hospital.hospitalserver.domain.entity;

import com.hospital.hospitalserver.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * 班次时间实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalTimeSlot extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 班次名称
     */
    private String slotName;

    /**
     * 班次代码
     */
    private String slotCode;

    /**
     * 班次开始时间
     */
    private LocalTime startTime;

    /**
     * 班次结束时间
     */
    private LocalTime endTime;

    /**
     * 班次状态：0-正常，1-禁用
     */
    private Integer isActive;

    /**
     * 班次描述
     */
    private String description;
}

