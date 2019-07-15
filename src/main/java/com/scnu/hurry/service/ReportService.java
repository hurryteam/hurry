package com.scnu.hurry.service;


import com.scnu.hurry.entity.Report;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReportService {

    List<Report> findToday(String openid);

    List<Report> findThisWeek(String openid);

    List<Report> findThisMonth(String openid);
}
