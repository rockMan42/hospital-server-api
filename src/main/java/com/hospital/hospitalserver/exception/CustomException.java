package com.hospital.hospitalserver.exception;

import com.hospital.hospitalserver.domain.enums.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义业务异常处理类（实时运行中的错误）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{
    private String message;
    private Integer code;

    /**
     * 通过枚举构造异常错误信息
     */
    public CustomException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }

    /**
     * 支持自定义消息
     */
    public CustomException(ResultCodeEnum resultCodeEnum, String message) {
        super(message);
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }
}
