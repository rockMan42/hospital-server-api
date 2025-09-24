package com.hospital.hospitalserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseUser {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 是否激活 0：未激活 1：已激活
     */
    private Integer isActive;

    /**
     * 角色名称
     */
    private String roleName;
}
