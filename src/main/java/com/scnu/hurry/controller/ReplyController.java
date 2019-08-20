package com.scnu.hurry.controller;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Reply;
import com.scnu.hurry.service.Impl.ReplyServiceImpl;

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
@RequestMapping("/reply")
@Api(value = "回答")
public class ReplyController {

    @Autowired
    ReplyServiceImpl replyService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "查询用户自己的回答", notes = "根据用户的openid传回size个回复")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "body", value = "必须包含用户openid: openid, 请求索引: index, 返回数量: size", dataType = "json", paramType = "body", required = true)
    })
    public List<Reply> findAllReply(@RequestBody Map<String, String> body) throws HurryException {
        Integer size = Integer.valueOf(body.get("size"));
        Integer index = Integer.valueOf(body.get("index"));
        String openid = body.get("openid");
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
        return replyService.findReplyByUserId(openid, pageRequest).getContent();
    }

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    @ApiOperation(value = "根据问题id查找回复", notes = "每次返回3条")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "questionId", value = "问题的openid", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "index", value = "请求的索引(从0开始)", dataType = "int", paramType = "query", required = true),
    })
    public List<Reply> findReplyByQuestionId(@RequestParam("questionId") int questionId,
                                             @RequestParam("index") int index) throws HurryException {
        if (questionId < 0) {
            throw new HurryException(ResultEnum.QUESTION_ID_VALUE_ERROR);
        }
        if (index < 0) {
            throw new HurryException(ResultEnum.INDEX_VALUE_ERROR);
        }
        Pageable pageRequest = PageRequest.of(index, 3);
        return replyService.findByQuestionId(questionId, pageRequest).getContent();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加回复")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "body", value = "必须包含用户openid, 问题Id: questionId, 内容: content", dataType = "json", paramType = "body", required = true)
    })
    public void addReply(@RequestBody Map<String, String> body) throws HurryException {
        String openid = body.get("openid");
        Integer questionId = Integer.valueOf(body.get("questionid"));
        String content = body.get("content");
        if (openid.equals("")) {
            throw new HurryException(ResultEnum.USER_ID_ERROR);
        }
        if (questionId < 0) {
            throw new HurryException(ResultEnum.QUESTION_ID_VALUE_ERROR);
        }
        try {
            replyService.addReply(openid, questionId, content);
        } catch (HurryException e) {
            throw e;
        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除回复")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "replyId", value = "回复id", dataType = "int", paramType = "query", required = true)
    })
    public void removeReply(@RequestParam("replyId") Integer replyId) {
        replyService.removeReply(replyId);
    }
}
