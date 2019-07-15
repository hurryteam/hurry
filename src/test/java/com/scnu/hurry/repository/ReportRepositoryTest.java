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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportRepositoryTest {

    @Autowired
    private ReportRepository repository;
    @Test
    public void findToday() {
        Pageable pageable = PageRequest.of(0,2);
        List<Report> today = repository.findToday(1);
        today.forEach(System.out::println);
    }

    @Test
    public void findThisWeek(){
        List<Report> week = repository.findThisWeek(1);
        week.forEach(System.out::println);
    }


    @Test
    public void findThisMonth(){
        List<Report> week = repository.findThisMonth(1);
        week.forEach(System.out::println);
    }
}