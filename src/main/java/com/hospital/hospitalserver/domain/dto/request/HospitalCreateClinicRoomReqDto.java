package com.hospital.hospitalserver.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新增诊室 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalCreateClinicRoomReqDto {

    /**
     * 诊室名称
     */
    @NotNull(message = "诊室名称不能为空")
    private String name;

    /**
     * 诊室编号
     */
    @NotNull(message = "诊室编号不能为空")
    private String roomNumber;

    /**
     * 科室ID
     */
    @NotNull(message = "科室ID不能为空")
    private Integer departmentId;

    /**
     * 诊室位置
     */
    private String location;

    /**
     * 诊室状态：0-正常（默认），1-停用
     */
    private Integer status;
}
