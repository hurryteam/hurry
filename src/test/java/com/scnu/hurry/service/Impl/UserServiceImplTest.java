package com.scnu.hurry.service.Impl;

import com.scnu.hurry.entity.Report;
import com.scnu.hurry.service.ReportService;
import com.scnu.hurry.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void getUrlsByids() {
        userService.addUser("1", "url1");
        userService.addUser("2", "url2");
        Integer[] ids = {1, 2, 3};
        List<String> urls = new ArrayList(userService.findAllUserPictureByUserid(Arrays.asList(ids)));
        assertEquals(urls.get(0), "url1");
        assertEquals(urls.get(1), "url2");
        assertEquals(urls.get(2), "");
    }
}
