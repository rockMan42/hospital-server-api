package com.hospital.hospitalserver.domain.dto.request;

import com.hospital.hospitalserver.domain.PageAndSizeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 查询科室列表 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalGetDepartmentPageReqDtp extends PageAndSizeDto {
    /**
     * 科室名称
     */
    private String name;

    /**
     * 科室编码
     */
    private String code;

    /**
     * 医生姓名
     */
    private String doctorName;

    /***
     * 开始
     */
    private Integer start;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 类型
     */
    private Integer dcId;
}
