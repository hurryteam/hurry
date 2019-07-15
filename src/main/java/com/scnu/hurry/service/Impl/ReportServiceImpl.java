package com.scnu.hurry.service.Impl;

import com.scnu.hurry.entity.Report;
import com.scnu.hurry.repository.ReportRepository;
import com.scnu.hurry.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository repository;

    @Override
    public Page<Report> findToday(Integer userId, Pageable pageable) {
        return repository.findToday(userId,pageable);
    }

    @Override
    public Page<Report> findThisWeek(Integer userId, Pageable pageable) {

        return repository.findThisWeek(userId, pageable);
    }

    @Override
    public Page<Report> findThisMonth(Integer userId, Pageable pageable) {
        return repository.findThisMonth(userId, pageable);
    }
}
