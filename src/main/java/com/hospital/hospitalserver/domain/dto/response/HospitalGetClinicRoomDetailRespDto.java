package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 诊室详情响应 respDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetClinicRoomDetailRespDto {

    /**
     * 诊室ID
     */
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
     * 科室名称
     */
    private String departmentName;

    /**
     * 诊室位置
     */
    private String location;

    /**
     * 诊室状态：0-正常，1-停用
     */
    private Integer status;
}
