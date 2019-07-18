package com.scnu.hurry.service.Impl;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Report;
import com.scnu.hurry.entity.UserInfo;
import com.scnu.hurry.repository.ReportRepository;
import com.scnu.hurry.repository.UserInfoRepository;
import com.scnu.hurry.service.ReportService;
import com.scnu.hurry.util.TimeHandleUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository repository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public List<Integer> findToday(String openid) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if (user == null)
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        Integer userId = user.getUserId();
        return TimeHandleUtil.splitDayTo24Hours(repository.findToday(userId));
    }

    @Override
    public List<Integer> findThisWeek(String openid) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if (user == null)
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        Integer userId = user.getUserId();
        List<Report> reportList = repository.findThisWeek(userId);
        return TimeHandleUtil.splitWeekToDay(reportList);
    }

    @Override
    public List<Integer> findThisMonth(String openid) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if (user == null)
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        Integer userId = user.getUserId();
        List<Report> reportList = repository.findThisMonth(userId);
        return TimeHandleUtil.splitMonthTo4Week(reportList);
    }

    @Override
    public Report addReport(Integer userId, Date date) throws HurryException{
        Report report = new Report();
        report.setUserId(userId);
        report.setTime(date);
        report = repository.save(report);
        if (report == null) {
            throw new HurryException(ResultEnum.REPORT_CREATE_FAIL);
        }
        return report;
    }

    @Override
    public Report addReport(String openId, Date date) throws HurryException {
        UserInfo user = userInfoRepository.findByOpenid(openId);
        return this.addReport(user.getUserId(), date);
    }

    @Override
    public void addReport(String openId, List<Date> dates) throws HurryException{
        for (Date e : dates) {
            this.addReport(openId, e);
        }
    }
}
