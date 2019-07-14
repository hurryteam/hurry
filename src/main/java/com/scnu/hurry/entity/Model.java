package com.scnu.hurry.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Model {
    @Id
    @GeneratedValue
    private Integer modelId;

    private Integer userId;
    private Integer initNum;
    @Column(name="CREATE_TIME",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    private Date createTime;
}
