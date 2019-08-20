package com.scnu.hurry.service;

import com.scnu.hurry.dto.ReplyDTO;
import com.scnu.hurry.entity.Reply;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReplyService {

    /**
     * 根据问题查找回复
     */
    Page<Reply> findByQuestionId(Integer questionId, Pageable pageable);

    /**
     * 根据用户查找回复
     * @param openid
     * @param pageable
     * @return
     */
    Page<Reply> findReplyByUserId(String openid, Pageable pageable);

    /**
     * 根据用户查找回复，返回ReplyDTO对象
     * @param openid
     * @param pageable
     * @return
     */
    List<ReplyDTO> findReplyByOpenId(String openid, Pageable pageable);

    /**
     * 增加回复
     * @param openid
     * @param questionId
     * @param content
     * @return
     */
    Reply addReply(String openid, Integer questionId, String content);


    /**
     * 删除回复
     * @param replyId
     */
    void removeReply(Integer replyId);

    /**
     * 根据问题ID删除回复
     * @param questionId
     */
    void removeReplyByQuestionId(Integer questionId);
}
