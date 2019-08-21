package com.scnu.hurry.service.Impl;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.UserInfo;
import com.scnu.hurry.repository.UserInfoRepository;
import com.scnu.hurry.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public boolean findUser(String openid) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        return user != null;
    }

    @Override
    public String findUserPictureByUserId(Integer userId) {
        UserInfo userInfo = userInfoRepository.findByUserId(userId);
        if (userInfo == null) {
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        }
        return userInfo.getUrl();

    }
    @Override
    public void addUser(String openid, String url) {
        UserInfo userInfo = new UserInfo();
        userInfo.setBalance(new BigDecimal(0));
        userInfo.setOpenid(openid);
        userInfo.setUrl(url);
        UserInfo res = userInfoRepository.saveAndFlush(userInfo);
        if (res == null)
            throw new HurryException(ResultEnum.USER_CREATE_FAIL);
    }

    @Override
    public String findUserPictureByUserid(Integer userid) {
        var opt = userInfoRepository.findById(userid);
        if (!opt.isPresent()) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        return opt.get().getUrl();
    }
}
