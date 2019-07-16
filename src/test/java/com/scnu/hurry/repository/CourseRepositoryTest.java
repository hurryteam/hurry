package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void add(){
        Course course = new Course();
        course.setAuthor("张医生");
        course.setCourseName("摆脱烟瘾");
        course.setPrice(new BigDecimal(999.22));
        Course res = repository.save(course);
        assertNotNull(res);
    }

    @Test
    public void findAll() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<Course> courses = repository.findAll(pageable);
        courses.getContent().forEach(System.out::println);
        assertNotNull(courses);
    }

    @Test
    public void findByCourseIdIn() {

        List<Integer> courseIdList = Arrays.asList(1,3);
        Pageable pageable = PageRequest.of(0, 3);
        Page<Course> coursePage = repository.findByCourseIdIn(courseIdList, pageable);
        coursePage.getContent().forEach(System.out::println);
    }
}