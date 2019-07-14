package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    /**
     * 查询课程，返回一页
     * @param pageable
     * @return
     */
    Page<Course> findAll(Pageable pageable);

    /**
     * 根据课程列表查询课程
     * @param courseId
     * @param pageable
     * @return
     */
    Page<Course> findByCourseIdIn(List<Integer> courseId, Pageable pageable);
}
