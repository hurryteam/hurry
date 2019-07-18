package com.scnu.hurry.repository;

import com.scnu.hurry.entity.UserInfo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository repository;


    @Test
    public void findByOpenid() {
        UserInfo u = new UserInfo();
        u.setOpenid("123456");
        u.setBalance(new BigDecimal(100));
        try {
            repository.saveAndFlush(u);
            UserInfo user = repository.findByOpenid("123456");
            assertEquals(user.getOpenid(), u.getOpenid());
        }
        finally {
            repository.delete(u);
        }
    }
}