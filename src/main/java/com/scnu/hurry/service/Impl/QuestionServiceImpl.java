package com.scnu.hurry.service.Impl;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Question;
import com.scnu.hurry.entity.UserInfo;
import com.scnu.hurry.repository.QuestionRepository;
import com.scnu.hurry.repository.UserInfoRepository;
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

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * 用户查询自己的问题
     * @param openid
     * @param pageable
     * @return
     */
    @Override
    public Page<Question> findByUserId(String openid, Pageable pageable) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if (user == null)
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        Integer userId = user.getUserId();
        return repository.findByUserId(userId, pageable);
    }


    @Override
    public Question addQuestion(Question question) {
        Question addResult = repository.save(question);
        if (addResult == null)
            throw new HurryException(ResultEnum.QUESTION_CREAT_FAIL);
        return question;
    }

    @Override
    public void removeQuestion(Integer questionId) {
        repository.deleteById(questionId);
    }
}
