package com.hospital.hospitalserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDomain {
    /**
     * 主鍵
     */
    private Integer id;

    /**
     * 創建時間
     */
    private LocalDateTime createAt;

    /**
     * 修改時間
     */
    private LocalDateTime updateAt;
}
