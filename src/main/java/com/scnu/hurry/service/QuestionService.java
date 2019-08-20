package com.scnu.hurry.service;

import com.scnu.hurry.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {

    /**
     * 查询问题
     *
     * @param pageable
     * @return
     */
    Page<Question> findAll(Pageable pageable);

    /**
     * 用户查询自己的问题
     * @param openid
     * @param pageable
     * @return
     */
    Page<Question> findByUserId(String openid, Pageable pageable);

    /**
     * 增加问题
     *
     * @param openid
     * @param content
     * @return
     */
    Question addQuestion(String openid, String content);

    Question addQuestion(Question q);

    /**
     * 删除帖子
     *
     * @param questionId
     * @return
     */
    void removeQuestion(Integer questionId);

    Question findByQuestionId(Integer questionId);
}
