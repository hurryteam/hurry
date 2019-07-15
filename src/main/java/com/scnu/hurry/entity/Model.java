package com.scnu.hurry.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ApiModel("模型")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="模型Id", dataType = "Integer")
    private Integer modelId;

    @ApiModelProperty(value="用户Id", dataType = "Integer")
    private Integer userId;

    @ApiModelProperty(value="初始吸烟数", dataType = "Integer")
    private Integer initNum;

    @ApiModelProperty(value="创建日期", dataType = "Date")
    @Column(name="CREATE_TIME",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    private Date createTime;
}
