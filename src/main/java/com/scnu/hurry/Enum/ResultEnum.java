package com.scnu.hurry.Enum;

import lombok.Getter;

/**
 * 错误枚举类
 */

@Getter
public enum ResultEnum {
    USER_NOT_FOUND(1, "用户不存在"),
    USER_ID_ERROR(2, "openid为空"),
    USER_CREATE_FAIL(3, "用户创建失败"),
    QUESTION_CREAT_FAIL(4, "问题创建失败"),
    REPLY_CREATE_FAIL(5, "回复失败"),
    INDEX_VALUE_ERROR(6, "索引不能为负 "),
    SIZE_VALUE_ERROR(7, "大小不能为负"),
    QUESTION_ID_VALUE_ERROR(8, "问题id不能为负"),
    QUESTION_NOT_FIND(9, "问题不存在"),
    REPORT_CREATE_FAIL(10, "回复创建失败")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
