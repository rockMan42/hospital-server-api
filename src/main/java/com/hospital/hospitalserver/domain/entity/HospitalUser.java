package com.hospital.hospitalserver.domain.entity;

import lombok.*;

/****
 * 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalUser {
    /**
     * 用户ID（不是列表id）
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
