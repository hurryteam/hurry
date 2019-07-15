package com.scnu.hurry.service.Impl;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Report;
import com.scnu.hurry.entity.UserInfo;
import com.scnu.hurry.repository.ReportRepository;
import com.scnu.hurry.repository.UserInfoRepository;
import com.scnu.hurry.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository repository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public List<Report> findToday(String openid) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if (user == null)
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        Integer userId = user.getUserId();
        return repository.findToday(userId);
    }

    @Override
    public List<Report> findThisWeek(String openid) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if (user == null)
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        Integer userId = user.getUserId();
        return repository.findThisWeek(userId);
    }

    @Override
    public List<Report> findThisMonth(String openid) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if (user == null)
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        Integer userId = user.getUserId();
        return repository.findThisMonth(userId);
    }
}
