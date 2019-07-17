package com.scnu.hurry.service.Impl;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Reply;
import com.scnu.hurry.entity.UserInfo;
import com.scnu.hurry.repository.ReplyRepository;
import com.scnu.hurry.repository.UserInfoRepository;
import com.scnu.hurry.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyRepository repository;
    @Autowired
    private UserInfoRepository userInfoRepository;

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
     * @param openid
     * @param pageable
     * @return
     */
    @Override
    public Page<Reply> findReplyByUserId(String openid, Pageable pageable) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if (user == null)
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        Integer userId = user.getUserId();
        return repository.findByUserId(userId, pageable);
    }

    @Override
    public Reply addReply(Reply reply) {
        Reply save = repository.save(reply);
        if (save == null){
            throw new HurryException(ResultEnum.REPLY_CREATE_FAIL);
        }
        return save;
    }

    @Override
    public void removeReply(Integer replyId) {
        repository.deleteById(replyId);
    }
}
