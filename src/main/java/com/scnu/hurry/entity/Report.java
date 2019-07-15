package com.scnu.hurry.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@ApiModel("报告")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="报告项Id", dataType = "Integer")
    private Integer reportId;

    @ApiModelProperty(value="用户Id", dataType = "Integer")
    private Integer userId;
    @ApiModelProperty(value="吸烟日期", dataType = "Date")
    private Date time;
}
