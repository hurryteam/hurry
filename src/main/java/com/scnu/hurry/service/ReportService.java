package com.scnu.hurry.service;


import com.scnu.hurry.entity.Report;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReportService {

    List<Integer> findToday(String openid);

    List<Integer> findThisWeek(String openid);

    List<Integer> findThisMonth(String openid);
}
