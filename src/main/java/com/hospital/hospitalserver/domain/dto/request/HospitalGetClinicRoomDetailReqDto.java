package com.hospital.hospitalserver.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询诊室详情 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetClinicRoomDetailReqDto {

    /**
     * 诊室ID
     */
    @NotNull(message = "诊室ID不能为空")
    private Integer id;
}
