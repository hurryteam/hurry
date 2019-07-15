package com.scnu.hurry.service;


import com.scnu.hurry.entity.Report;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReportService {

    List<Report> findToday(Integer userId);

    List<Report> findThisWeek(Integer userId);

    List<Report> findThisMonth(Integer userId);
}
