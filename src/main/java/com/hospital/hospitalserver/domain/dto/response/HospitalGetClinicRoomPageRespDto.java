package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询诊室列表(只要名称和id) respDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetClinicRoomPageRespDto {

    /**
     * 诊室id
     */
    private Integer clinicRoomId;

    /**
     * 诊室名称
     */
    private String name;
}
