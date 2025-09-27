package com.hospital.hospitalserver.domain.dto.response;

import lombok.Data;

/**
 * 医生职称响应DTO
 */
@Data
public class HospitalGetProfessionTitleRespDto {
    /**
     * 职称ID
     */
    private Integer id;
    
    /**
     * 职称名称
     */
    private String profashionTitle;
}
