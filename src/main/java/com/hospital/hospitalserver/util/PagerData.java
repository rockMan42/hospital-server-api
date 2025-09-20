package com.hospital.hospitalserver.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工具栏
 * 负责传递分页数据
 * 包括页码，数据集合等
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagerData {
    private Object data;
    private Integer pageTotal;
}
