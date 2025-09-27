package com.hospital.hospitalserver.domain.dto.request;

import com.hospital.hospitalserver.domain.PageAndSizeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 查询医生完整分页列表 reqDto
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetDoctorFullPageReqDto extends PageAndSizeDto {

    /**
     * 工号
     */
    private String workId;

    /**
     * 医生姓名
     */
    private String name;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 职称ID
     */
    private Integer ptId;

    /**
     * 开始位置（用于分页）
     */
    private Integer start;
}
