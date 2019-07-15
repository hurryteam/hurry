package com.scnu.hurry.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ApiModel("提问")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="问题Id", dataType = "Integer")
    private Integer questionId;

    @ApiModelProperty(value="提问用户Id", dataType = "Integer")
    private Integer userId;

    @ApiModelProperty(value="问题内容", dataType = "String")
    private String questionContent;
}
