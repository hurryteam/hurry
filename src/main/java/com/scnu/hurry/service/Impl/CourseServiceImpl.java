package com.scnu.hurry.service.Impl;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl {
=======
import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Course;
import com.scnu.hurry.entity.Selection;
import com.scnu.hurry.repository.CourseRepository;
import com.scnu.hurry.repository.SelectionRepository;
import com.scnu.hurry.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SelectionRepository selectionRepository;

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Page<Course> findUserCourse(Integer userId, Pageable pageable) {

        //得到用户的选课
        List<Selection> userSelection = selectionRepository.findAllByUserId(userId);
        //查询为空则报错
        if (CollectionUtils.isEmpty(userSelection)){
            log.error("【课程查询】用户不存在，userId={}", userId);
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        }
        //得到用户所有课的课程id
        List<Integer> userCourseIdList = userSelection.stream().map(Selection::getCourseId)
                .collect(Collectors.toList());
        Page<Course> courseList = courseRepository.findByCourseIdIn(userCourseIdList, pageable);
        return courseList;
    }
>>>>>>> service
}
