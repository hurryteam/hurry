package com.scnu.hurry.service.Impl;

import com.scnu.hurry.entity.UserInfo;
import com.scnu.hurry.repository.UserInfoRepository;
import com.scnu.hurry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public boolean findUser(String openid) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        return user != null;
    }
}
