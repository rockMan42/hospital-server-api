package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.entity.HospitalStaffType;
import com.hospital.hospitalserver.domain.entity.HospitalTimeSlot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalScheduleMapper {

    /**
     * 获取员工类型列表（精简版）
     *
     * @return
     */
    List<HospitalStaffType> getStaffTypeSlimList();
    /**
     * 获取班次时间信息列表（精简版）
     *
     * @return
     */
    List<HospitalTimeSlot> getTimeSlotSlimList();
}
