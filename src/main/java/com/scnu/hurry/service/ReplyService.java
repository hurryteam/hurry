package com.scnu.hurry.service;

import com.scnu.hurry.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReplyService {

    /**
     * 根据问题查找回复
     * @param questionId
     * @param pageable
     * @return
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
     * 增加回复
     * @param userId
     * @param questionId
     * @param content
     * @return
     */
    Reply addReply(Integer userId, Integer questionId, String content);


    /**
     * 删除回复
     * @param replyId
     */
    void removeReply(Integer replyId);
}
