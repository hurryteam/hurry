package com.scnu.hurry.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Selection {
    @Id
    @GeneratedValue
    private Integer selectionId;

    private Integer userId;
    private Integer courseId;
}
