package com.hospital.hospitalserver.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 删除患者 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDeletePatientReqDto {

    /**
     * 待删除的患者ID列表
     */
    @NotEmpty(message = "患者ID列表不能为空")
    private List<Integer> ids;
}
