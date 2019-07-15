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
     * @param userId
     * @param pageable
     * @return
     */
    Page<Reply> findQuestionByUserId(Integer userId, Pageable pageable);

}
