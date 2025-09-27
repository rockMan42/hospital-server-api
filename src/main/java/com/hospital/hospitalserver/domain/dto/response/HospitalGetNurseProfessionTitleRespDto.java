package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 护士职称列表响应DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetNurseProfessionTitleRespDto {

    /**
     * 职称ID
     */
    private Integer id;

    /**
     * 职称名称
     */
    private String profashionTitle;
}
