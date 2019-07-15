package com.scnu.hurry.service.Impl;

import com.scnu.hurry.entity.Question;
import com.scnu.hurry.repository.QuestionRepository;
import com.scnu.hurry.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    /**
     * 查询问题
     *
     * @param pageable
     * @return
     */
    @Autowired
    private QuestionRepository repository;
    @Override
    public Page<Question> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * 用户查询自己的问题
     * @param userId
     * @param pageable
     * @return
     */
    @Override
    public Page<Question> findByUserId(Integer userId, Pageable pageable) {
        return repository.findByUserId(userId, pageable);
    }
}
