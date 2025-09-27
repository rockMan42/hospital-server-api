package com.hospital.hospitalserver.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统计费用项目类型数量，启用数量，停用数量，当天新增
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeItemsRespDto {
    private Integer totalCount;
    private Integer activeCount;
    private Integer inactiveCount;
    private Integer todayUpdateCount;
}
