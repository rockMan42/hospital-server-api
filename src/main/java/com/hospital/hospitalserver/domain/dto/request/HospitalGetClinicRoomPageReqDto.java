package com.hospital.hospitalserver.domain.dto.request;

import com.hospital.hospitalserver.domain.PageAndSizeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取诊室分页列表 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetClinicRoomPageReqDto extends PageAndSizeDto {

    /**
     * id
     */
    private Integer id;

    /**
     * 科室ID（筛选条件）
     */
    private String departmentName;

    /**
     * 诊室名称（搜索条件）
     */
    private String name;

    /**
     * 诊室编号（搜索条件）
     */
    private String roomNumber;

    /**
     * 诊室状态（筛选条件）
     */
    private Integer status;

    /**
     * 开始索引
     */
    private Integer start;
}
