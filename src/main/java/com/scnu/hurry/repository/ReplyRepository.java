package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    /**
     * 根据问题查找回答，这里是每个问题的回答
     * @param questionId 问题id
     * @param pageable
     * @return
     */
    Page<Reply> findByQuestionId(Integer questionId, Pageable pageable);

    /**
     * 根据用户查找回答
     * @param userId
     * @param pageable
     * @return
     */
    Page<Reply> findByUserId(Integer userId, Pageable pageable);

    /**
     * 根据问题id删除回复
     * @param questionId
     */
    void deleteByQuestionId(Integer questionId);
}
