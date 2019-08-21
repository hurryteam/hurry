package com.scnu.hurry.service.Impl;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.dto.ReplyDTO;
import com.scnu.hurry.entity.Question;
import com.scnu.hurry.entity.Reply;
import com.scnu.hurry.entity.UserInfo;
import com.scnu.hurry.repository.QuestionRepository;
import com.scnu.hurry.repository.ReplyRepository;
import com.scnu.hurry.repository.UserInfoRepository;
import com.scnu.hurry.service.ReplyService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyRepository repository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private QuestionRepository questionRepository;

    /**
     * 查询问题的回答
     */
    @Override
    public Page<Reply> findByQuestionId(Integer questionId, Pageable pageable) {
        if (!repository.existsById(questionId)) {
            throw new HurryException(ResultEnum.QUESTION_NOT_FIND);
        }
        return repository.findByQuestionId(questionId, pageable);
    }

    /**
     * 查询用户自己的回答
     */
    @Override
    public Page<Reply> findReplyByUserId(String openid, Pageable pageable) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if (user == null)
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        Integer userId = user.getUserId();
        return repository.findByUserId(userId, pageable);
    }

    public Reply addReply(Integer userId, Integer questionId, String content) {
        Reply reply = new Reply();
        reply.setQuestionId(questionId);
        reply.setReplyContent(content);
        reply.setUserId(userId);
        Reply save = repository.saveAndFlush(reply);
        return save;
    }


    @Override
    public Reply addReply(String openid, Integer questionId, String content) throws HurryException {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if (user == null) {
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        }
        return this.addReply(user.getUserId(), questionId, content);
    }

    @Override
    public void removeReply(Integer replyId) {
        repository.deleteById(replyId);
    }

    @Override
    public List<ReplyDTO> findReplyByOpenId(String openid, Pageable pageable) {
        UserInfo userInfo = userInfoRepository.findByOpenid(openid);
        if (userInfo == null)
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        List<Reply> replies = repository.findByUserId(userInfo.getUserId(), pageable).getContent();
        List<Integer> questionIds = replies.stream().map(Reply::getQuestionId)
                .collect(Collectors.toList());
        List<Question> questions = questionRepository.findAllByQuestionIdIn(questionIds);
        int size = replies.size();
        List<ReplyDTO> replyDTOS = new ArrayList<>(size);
        for (Reply reply : replies){
            ReplyDTO replyDTO = new ReplyDTO();
            BeanUtils.copyProperties(reply, replyDTO);
            //查找问题内容
            for (Question q : questions){
                if (q.getQuestionId().equals(reply.getQuestionId())){
                    replyDTO.setQuestionContent(q.getQuestionContent());
                }
            }
            replyDTOS.add(replyDTO);
        }
        return replyDTOS;
    }

    @Override
    public void removeReplyByQuestionId(Integer questionId) {
        repository.deleteByQuestionId(questionId);
    }
}
