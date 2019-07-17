package com.scnu.hurry.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@ApiModel("用户信息")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="用户Id", dataType = "Integer")
    private Integer userId;

    @ApiModelProperty(value="微信用户openId", dataType = "String")
    private String openid;
    @ApiModelProperty(value="用户余额", dataType = "BigDecimal")
    private BigDecimal balance;
    @ApiModelProperty(value = "用户头像url", dataType = "String")
    private String url;
}
