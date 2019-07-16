package com.scnu.hurry.service.Impl;

import com.scnu.hurry.entity.Report;
import com.scnu.hurry.service.ReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportServiceImplTest {

    @Autowired
    private ReportService service;
    @Test
    public void findToday() {
        List<Integer> today = service.findToday("151551");
        today.forEach(System.out::println);
    }

    @Test
    public void findThisWeek() {
        List<Integer> today = service.findThisWeek("151551");
        today.forEach(System.out::println);
    }

    @Test
    public void findThisMonth() {
        List<Integer> today = service.findThisMonth("151551");
        today.forEach(System.out::println);
    }
}