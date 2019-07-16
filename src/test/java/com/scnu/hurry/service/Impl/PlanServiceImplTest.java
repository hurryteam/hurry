package com.scnu.hurry.service.Impl;

import com.scnu.hurry.service.PlanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanServiceImplTest {
    @Autowired
    private PlanService planService;

    @Test
    public void getPlan() {
        Integer plan = planService.getPlan("151551");
        System.out.println(plan);
    }
}