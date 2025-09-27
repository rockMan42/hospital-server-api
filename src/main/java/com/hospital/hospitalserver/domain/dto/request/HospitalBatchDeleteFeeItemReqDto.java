package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 批量删除费用项目 reqDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalBatchDeleteFeeItemReqDto {

    /**
     * 费用项目ID列表
     */
    @NotEmpty(message = "费用项目ID列表不能为空")
    private List<Long> ids;
}
