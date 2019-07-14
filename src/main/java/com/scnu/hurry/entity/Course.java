package com.scnu.hurry.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Integer courseId;
    private String courseName;
    private String author;
    private BigDecimal price;
    @Column(name="CREATE_TIME",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    private Date createTime;
}
