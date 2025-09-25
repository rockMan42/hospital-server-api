package com.hospital.hospitalserver.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 新增用户 reqDto
 */
@Data
@AllArgsConstructor
public class HospitalCreateUser {

    /**
     * 用户id
     */
    private Integer id;

    /***
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 是否激活
     */
    private Integer isActive;
}
