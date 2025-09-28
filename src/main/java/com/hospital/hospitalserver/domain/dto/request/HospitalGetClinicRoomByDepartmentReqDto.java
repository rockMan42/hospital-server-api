package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * 根据科室ID查询诊室列表请求DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetClinicRoomByDepartmentReqDto {

    /**
     * 科室ID
     */
    @NotNull(message = "科室ID不能为空")
    private Integer departmentId;
}
