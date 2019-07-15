package com.scnu.hurry.service;


import com.scnu.hurry.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReportService {

    Page<Report> findToday(Integer userId, Pageable pageable);

    Page<Report> findThisWeek(Integer userId, Pageable pageable);

    Page<Report> findThisMonth(Integer userId, Pageable pageable);
}
