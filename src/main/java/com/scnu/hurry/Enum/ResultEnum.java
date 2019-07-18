package com.scnu.hurry.Enum;

import lombok.Getter;

/**
 * 错误枚举类
 */

@Getter
public enum ResultEnum {
    USER_NOT_FOUND(1, "用户不存在"),
    USER_CREATE_FAIL(2, "用户创建失败"),
    QUESTION_CREAT_FAIL(3, "问题创建失败"),
    REPLY_CREATE_FAIL(4, "回复创建失败"),
    SIZE_VALUE_ERROR(5, "大小非法"),
    INDEX_VALUE_ERROR(6, "索引非法"),
    USER_ID_ERROR(7, "用户openid非法"),
    QUESTION_ID_VALUE_ERROR(8, "问题id非法")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
