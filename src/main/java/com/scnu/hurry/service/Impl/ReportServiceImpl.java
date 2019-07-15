package com.scnu.hurry.service.Impl;

import com.scnu.hurry.entity.Report;
import com.scnu.hurry.repository.ReportRepository;
import com.scnu.hurry.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository repository;

    @Override
    public List<Report> findToday(Integer userId) {
        return repository.findToday(userId);
    }

    @Override
    public List<Report> findThisWeek(Integer userId) {

        return repository.findThisWeek(userId);
    }

    @Override
    public List<Report> findThisMonth(Integer userId) {
        return repository.findThisMonth(userId);
    }
}
