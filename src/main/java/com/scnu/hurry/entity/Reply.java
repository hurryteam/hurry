package com.scnu.hurry.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ApiModel("回复")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="回复内容", dataType = "Integer")
    private Integer replyId;

    @ApiModelProperty(value="问题Id", dataType = "Integer")
    private Integer questionId;
    @ApiModelProperty(value="回复者Id", dataType = "Integer")
    private Integer userId;
    @ApiModelProperty(value="回复内容", dataType = "String")
    private String replyContent;

}
