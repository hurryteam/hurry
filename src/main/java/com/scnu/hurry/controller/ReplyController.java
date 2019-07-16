package com.scnu.hurry.controller;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Reply;
import com.scnu.hurry.service.Impl.ReplyServiceImpl;

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
@Api(value = "回答查询控制器")
public class ReplyController {

    @Autowired
    ReplyServiceImpl replyService;

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    @ApiOperation(value = "查询自己的回答", notes = "根据用户的openid传回size个回复")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "openid", value = "用户的openid", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "index", value = "请求的索引", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "size", value = "返回课程数量", dataType = "int", paramType = "query", defaultValue = "3")
    })
    List<Reply> findAllReply(@RequestParam("openid") String openid,
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
        Pageable pageRequest = new PageRequest(index, size);
        return replyService.findReplyByUserId(openid, pageRequest).getContent();
    }

    @RequestMapping(value = "/reply/question", method = RequestMethod.GET)
    @ApiOperation(value = "根据问题id查找回复", notes = "每次返回3条")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "questionId", value = "问题的openid", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "index", value = "请求的索引", dataType = "int", paramType = "query", required = true),
    })
    List<Reply> findReplyByQuestionId(@RequestParam("questionId") int questionId,
                                      @RequestParam("index") int index) {
        if (questionId < 0) {
            throw new HurryException(ResultEnum.QUESTION_ID_VALUE_ERROR);
        }
        if (index < 0) {
            throw new HurryException(ResultEnum.INDEX_VALUE_ERROR);
        }
        Pageable pageRequest = new PageRequest(index, 3);
        return replyService.findByQuestionId(questionId, pageRequest).getContent();
    }


}
