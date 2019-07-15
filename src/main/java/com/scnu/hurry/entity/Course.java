package com.scnu.hurry.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("课程")
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "课程id", dataType = "Integer")
    private Integer courseId;

    @ApiModelProperty(value = "课程名", dataType = "String")
    private String courseName;

    @ApiModelProperty(value = "课程作者", dataType = "String")
    private String author;

    @ApiModelProperty(value = "课程价格", dataType = "BigDecimal")
    private BigDecimal price;

    @ApiModelProperty(value = "创建日期", dataType = "Date")
    @Column(name = "CREATE_TIME", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date createTime;
}
