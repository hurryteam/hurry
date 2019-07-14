package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Report;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


import javax.swing.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportRepositoryTest {

    @Autowired
    private ReportRepository repository;
    @Test
    public void findToday() {
        Pageable pageable = PageRequest.of(0,2);
        Page<Report> today = repository.findToday(pageable);
        today.getContent().forEach(System.out::println);
    }

    @Test
    public void findThisWeek(){
        Pageable pageable = PageRequest.of(0,10);
        Page<Report> week = repository.findThisWeek(pageable);
        week.getContent().forEach(System.out::println);
    }


    @Test
    public void findThisMonth(){
        Pageable pageable = PageRequest.of(0,10);
        Page<Report> week = repository.findThisMonth(pageable);
        week.getContent().forEach(System.out::println);
    }
}