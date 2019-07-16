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

import java.util.ArrayList;
import java.util.Calendar;
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
}
