package com.scnu.hurry.controller;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Question;
import com.scnu.hurry.service.Impl.QuestionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/question")
@Api(value = "问题(帖子)")
public class QuestionController {

    @Autowired
    QuestionServiceImpl questionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "返回所有的问题")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "index", value = "请求的索引(从0开始)", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "size", value = "返回课程数量", dataType = "int", paramType = "query", defaultValue = "3")
    })

    public List<Question> getQuestions(@RequestParam("index") int index,
                                       @RequestParam("size")  int size) throws HurryException {
        if (size < 0) {
            throw new HurryException(ResultEnum.SIZE_VALUE_ERROR);
        }
        if (index < 0) {
            throw new HurryException(ResultEnum.INDEX_VALUE_ERROR);
        }
        Pageable pageRequest = PageRequest.of(index, size);
        return questionService.findAll(pageRequest).getContent();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "根据用户查询其发布的问题")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "openid", value = "用户的openid", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "index", value = "请求的索引(从0开始)", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "size", value = "返回的数量", dataType = "int", paramType = "query", defaultValue = "3"),
    })
    public List<Question> getQustionsByUserId(@RequestParam("openid") String openid,
                                              @RequestParam("index") int index) {
        if (index < 0) {
            throw new HurryException(ResultEnum.INDEX_VALUE_ERROR);
        }
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        Pageable pageRequest = PageRequest.of(index, 3);
        return questionService.findByUserId(openid, pageRequest).getContent();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加问题")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "openid", value = "用户的openid", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "content", value = "问题内容", dataType = "String", paramType = "query")
    })
    public void addQuestion(@RequestParam("openid") String openid,
                            @RequestParam("content") String content) throws HurryException {
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        try {
            questionService.addQuestion(openid, content);
        } catch (HurryException e) {
            throw e;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除问题")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "questionId", value = "问题的Id", dataType = "Integer", paramType = "query", required = true)
    })
    public void removeQuestion(@RequestParam("questionId") Integer questionId) throws HurryException {
        if (questionId < 0) {
            throw new HurryException(ResultEnum.QUESTION_ID_VALUE_ERROR);
        }
        questionService.removeQuestion(questionId);
    }
}
