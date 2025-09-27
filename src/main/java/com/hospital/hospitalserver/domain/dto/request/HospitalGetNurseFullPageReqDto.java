package com.hospital.hospitalserver.domain.dto.request;

import com.hospital.hospitalserver.domain.PageAndSizeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 查询护士完整分页列表 reqDto
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetNurseFullPageReqDto extends PageAndSizeDto {

    /**
     * 工号
     */
    private String workId;

    /**
     * 护士姓名
     */
    private String name;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 状态 0在岗1休假2停职
     */
    private Integer status;

    /**
     * 护士职称ID
     */
    private Integer nptId;

    /**
     * 开始位置（用于分页）
     */
    private Integer start;
}
