package com.scnu.hurry.service;

import com.scnu.hurry.dto.ReplyDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyServiceTest {
    @Autowired
    private ReplyService replyService;

    @Test
    public void findByQuestionId() {
    }

    @Test
    public void findReplyByOpenId(){
        Pageable pageable = PageRequest.of(0,3);
        List<ReplyDTO> replyDTOs = replyService.findReplyByOpenId("测试", pageable);
        replyDTOs.forEach(System.out::println);

    }
}