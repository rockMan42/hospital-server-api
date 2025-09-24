package com.hospital.hospitalserver.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

/****
 * 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalUser {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否激活 0：未激活 1：已激活
     */
    private Integer isActive;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;
}
