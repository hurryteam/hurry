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
     * @param userId
     * @param pageable
     * @return
     */
    Page<Question> findByUserId(Integer userId, Pageable pageable);
}
