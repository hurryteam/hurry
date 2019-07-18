package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Report;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportRepositoryTest {

    @Autowired
    private ReportRepository repository;

    @Test
    public void addReport() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Report report = new Report();
        report.setUserId(1);
        timestamp.setDate(1);
        report.setTime(timestamp);
        repository.save(report);
        repository.delete(report);
    }

    @Test
    public void findToday() {
        ArrayList<Report> reports = new ArrayList<>(24);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        for (int i = 0; i < 24; i++) {
            Report report = new Report();
            report.setUserId(1);
            timestamp.setDate(i);
            report.setTime(timestamp);
            repository.saveAndFlush(report);
            reports.add(report);
        }
        try {
            List<Report> today = repository.findToday(1);
            today.forEach(System.out::println);
        }
        finally {
            reports.forEach(repository::delete);
        }
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