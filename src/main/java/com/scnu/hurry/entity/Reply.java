package com.scnu.hurry.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Reply {
    @Id
    @GeneratedValue
    private Integer replyId;

    private Integer questionId;
    private Integer userId;
    private String replyContent;

}
