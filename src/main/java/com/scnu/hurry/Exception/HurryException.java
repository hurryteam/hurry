package com.scnu.hurry.Exception;

import com.scnu.hurry.Enum.ResultEnum;

/**
 * 统一异常处理类
 */
public class HurryException extends RuntimeException {

    private Integer code;

    public HurryException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
