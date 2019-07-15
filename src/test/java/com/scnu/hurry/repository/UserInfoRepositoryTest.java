package com.scnu.hurry.repository;

import com.scnu.hurry.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository repository;
    @Test
    public void findByOpenid() {
        UserInfo user = repository.findByOpenid("151551");
        System.out.println(user);
    }
}