package com.scnu.hurry.service.Impl;

import com.scnu.hurry.entity.Course;
import com.scnu.hurry.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;
    @Test
    public void findAll() {

    }

    @Test
    public void findUserCourse() {
        Pageable pageable = PageRequest.of(0,10);
        Page<Course> userCourse = courseService.findUserCourse(2, pageable);
        userCourse.getContent().forEach(System.out::println);
    }
}