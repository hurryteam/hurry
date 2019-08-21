package com.scnu.hurry.controller;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Course;
import com.scnu.hurry.service.Impl.CourseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/course")
@Api(value = "课程")
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有的课程")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "index", value = "请求的索引(从0开始)", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "size", value = "返回课程数量", dataType = "int", paramType = "query", required = true)
    })
    public List<Course> getCourses(@RequestParam("index") int index,
                                  @RequestParam("size") int size) throws HurryException {
        if (size < 0) {
            throw new HurryException(ResultEnum.SIZE_VALUE_ERROR);
        }
        if (index < 0) {
            throw new HurryException(ResultEnum.INDEX_VALUE_ERROR);
        }
        Pageable pageRequest = PageRequest.of(index, size);
        return courseService.findAll(pageRequest).getContent();
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ApiOperation(value = "查询用户选中的课程")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "openid", value = "用户的openid", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "index", value = "请求的索引(从0开始)", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "size", value = "返回课程数量", dataType = "int", paramType = "query", defaultValue = "3")
    })
    public List<Course> getUserCourse(@RequestParam("openid") String openid,
                                  @RequestParam("index") int index,
                                  @RequestParam("size") int size) throws HurryException {
        if (size < 0) {
            throw new HurryException(ResultEnum.SIZE_VALUE_ERROR);
        }
        if (index < 0) {
            throw new HurryException(ResultEnum.INDEX_VALUE_ERROR);
        }
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        Pageable pageRequest = PageRequest.of(index, size);
        return courseService.findUserCourse(openid, pageRequest).getContent();
    }

    @GetMapping(value = "/selected")
    @ApiOperation(value = "查询用户是否选了某门课")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "query", value = "包含用户的openId: openId, 课程的id: courseId", dataType = "json", paramType = "body", required = true)
    })
    public boolean isSelectionExist(@RequestBody Map<String, String> query) {
        String openId = query.get("openId");
        Integer courseId = Integer.parseInt(query.get("courseId"));
        return courseService.checkIsUserSelect(courseId, openId);
    }
}
