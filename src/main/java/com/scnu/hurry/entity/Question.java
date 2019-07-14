package com.scnu.hurry.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue
    private Integer questionId;

    private Integer userId;
    private String questionContent;
}
