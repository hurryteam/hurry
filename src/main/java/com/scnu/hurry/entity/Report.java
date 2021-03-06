package com.scnu.hurry.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Report {

    @Id
    @GeneratedValue
    private Integer reportId;

    private Integer userId;
    private Date time;
}
