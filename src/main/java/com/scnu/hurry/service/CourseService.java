package com.scnu.hurry.service;

import com.scnu.hurry.entity.Course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    /**
     * 返回请求的课程列表
     */
    Page<Course> findAll(Pageable pageable);

    /**
     * 查询用户自己选择的课程
     */
    Page<Course> findUserCourse(Integer userId, Pageable pageable);
}
