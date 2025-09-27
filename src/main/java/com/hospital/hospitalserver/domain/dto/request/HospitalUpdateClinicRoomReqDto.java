package com.hospital.hospitalserver.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新诊室信息 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalUpdateClinicRoomReqDto {

    /**
     * 诊室ID
     */
    @NotNull(message = "诊室ID不能为空")
    private Integer id;

    /**
     * 诊室名称
     */
    private String name;

    /**
     * 诊室编号
     */
    private String roomNumber;

    /**
     * 科室ID
     */
    private Integer departmentId;

    /**
     * 诊室位置
     */
    private String location;

    /**
     * 诊室状态：0-正常，1-停用
     */
    private Integer status;
}
