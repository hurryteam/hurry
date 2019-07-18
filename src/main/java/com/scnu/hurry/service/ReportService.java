package com.scnu.hurry.service;


import com.scnu.hurry.entity.Report;

import java.util.List;
import java.util.Date;

public interface ReportService {

    List<Integer> findToday(String openid);

    List<Integer> findThisWeek(String openid);

    List<Integer> findThisMonth(String openid);

    Report addReport(Integer userId, Date date);

    Report addReport(String openid, Date date);

    void addReport(String openId, List<Date> dates);
}
