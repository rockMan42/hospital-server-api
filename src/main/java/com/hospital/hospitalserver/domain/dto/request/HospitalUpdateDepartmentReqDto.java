package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * 修改科室信息 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalUpdateDepartmentReqDto {

    /**
     * 科室ID
     */
    @NotNull(message = "科室ID不能为空")
    private Integer id;

    /**
     * 科室名称
     */
    private String name;

    /**
     * 科室编码
     */
    private String code;

    /**
     * 科室描述
     */
    private String description;

    /**
     * 科室类型ID
     */
    private Integer dcId;

    /**
     * 科室主任医生ID
     */
    private Integer doctorId;

    /**
     * 科室主任职称
     */
    private String jobTitle;

    /**
     * 科室联系电话
     */
    private String phone;

    /**
     * 科室成立时间
     */
    private LocalDate establishedTime; // 格式（yyyy-MM-dd）

    /**
     * 科室状态：0-正常，1-停用
     */
    private Integer status;
}
