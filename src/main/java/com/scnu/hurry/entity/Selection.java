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
@ApiModel("选课")
public class Selection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "选课表", dataType = "Integer")
    private Integer selectionId;

    @ApiModelProperty(value = "用户Id", dataType = "Integer")
    private Integer userId;

    @ApiModelProperty(value = "课程Id", dataType = "Integer")
    private Integer courseId;
}
