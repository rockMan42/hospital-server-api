package com.hospital.hospitalserver.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 删除诊室 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDeleteClinicRoomReqDto {

    /**
     * 诊室ID列表
     */
    @NotEmpty(message = "诊室ID列表不能为空")
    private List<Integer> ids;
}
