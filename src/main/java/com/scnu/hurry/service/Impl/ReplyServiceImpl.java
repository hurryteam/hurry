package com.scnu.hurry.service.Impl;

import com.scnu.hurry.entity.Reply;
import com.scnu.hurry.repository.ReplyRepository;
import com.scnu.hurry.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyRepository repository;

    /**
     * 查询问题的回答
     * @param questionId
     * @param pageable
     * @return
     */
    @Override
    public Page<Reply> findByQuestionId(Integer questionId, Pageable pageable) {

        return repository.findByQuestionId(questionId, pageable);
    }

    /**
     * 查询用户自己的回答
     * @param userId
     * @param pageable
     * @return
     */
    @Override
    public Page<Reply> findQuestionByUserId(Integer userId, Pageable pageable) {
        return repository.findByUserId(userId, pageable);
    }
}
