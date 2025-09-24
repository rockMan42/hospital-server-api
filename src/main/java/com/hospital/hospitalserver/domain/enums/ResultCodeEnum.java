package com.hospital.hospitalserver.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统常用错误
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS(200, "操作成功"),
    ERROR(203,"操作失败"),
    SYSTEM_ERROR(500, "系统繁忙"),
    // 用户相关错误信息
    LOGIN_SUCCESS(200,"登录成功"),
    LOGIN_ERROR(401,"登录失败");
    private final Integer code;
    private final String message;
}
