package com.scnu.hurry.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class UserInfo {

    @Id
    @GeneratedValue
    private Integer userId;
    private String openid;
    private BigDecimal balance;
}
