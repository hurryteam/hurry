package com.scnu.hurry.Enum;

import lombok.Getter;

/**
 * 错误枚举类
 */

@Getter
public enum ResultEnum {
    USER_NOT_FOUND(1, "用户不存在"),

    USER_ID_ERROR(2, "openid为空"),
    INDEX_VALUE_ERROR(3, "索引需为非负值 "),
    SIZE_VALUE_ERROR(4, "大小不能为负");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
