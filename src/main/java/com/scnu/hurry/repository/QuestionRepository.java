package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    /**
     * 请求帖子
     * @param pageable
     * @return
     */
    Page<Question> findAll(Pageable pageable);

    /**
     * 用户查询自己的回答
     * @param userId
     * @param pageable
     * @return
     */
    Page<Question> findByUserId(Integer userId, Pageable pageable);

    List<Question> findAllByQuestionIdIn(List<Integer> qIds);
}
