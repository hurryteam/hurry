package com.scnu.hurry.controller;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Question;
import com.scnu.hurry.service.Impl.QuestionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
                                       @RequestParam("size") int size) throws HurryException {
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
            @ApiImplicitParam(name = "body", value = "含用户openid: openid, 请求索引: index, 返回数量: size", dataType = "json", paramType = "body", required = true)
    })
    public List<Question> getQustionsByUserId(@RequestBody Map<String, String> map) {
        Integer index = Integer.valueOf(map.get("index"));
        Integer size = Integer.valueOf(map.get("size"));
        String openid = map.get("openid");
        if (index < 0) {
            throw new HurryException(ResultEnum.INDEX_VALUE_ERROR);
        }
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        } 
        if (size < 0) {
            throw new HurryException(ResultEnum.SIZE_VALUE_ERROR);
        }
        Pageable pageRequest = PageRequest.of(index, size);
        return questionService.findByUserId(openid, pageRequest).getContent();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加问题")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "body", value = "必须包含用户openid, 还有内容content", dataType = "json", paramType = "body", required = true)
    })
    public void addQuestion(@RequestBody Map<String, String> body) throws HurryException {
        if (body.get("openid").equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        try {
            questionService.addQuestion(body.get("openid"), body.get("content"));
        } catch (HurryException e) {
            throw e;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除问题")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "questionId", value = "问题的Id", dataType = "Integer", paramType = "query", required = true)
    })
    public String removeQuestion(@RequestParam("questionId") String questionId) throws HurryException {
        Integer id = Integer.parseInt(questionId); 
        if (id< 0) {
            throw new HurryException(ResultEnum.QUESTION_ID_VALUE_ERROR);
        }
        questionService.removeQuestion(id);
        return "success";
    }
}
