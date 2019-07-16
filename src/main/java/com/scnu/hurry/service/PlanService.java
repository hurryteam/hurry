package com.scnu.hurry.service;

/**
 * 计划
 */
public interface PlanService {

    /**
     * 查找用户的计划
     * @param openid
     * @return
     */
    Integer getPlan(String openid);
}
