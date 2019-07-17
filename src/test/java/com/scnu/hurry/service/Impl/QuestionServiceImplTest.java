package com.scnu.hurry.service.Impl;

import com.scnu.hurry.entity.Question;
import com.scnu.hurry.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceImplTest {

    @Autowired
    private QuestionService service;
    @Test
    public void findAll() {

    }

    @Test
    public void findByUserId() {
    }

    @Test
    public void addQuestion() {
        Question q = new Question();
        q.setUserId(1);
        q.setQuestionContent("第二个问题");
        Question question = service.addQuestion(q);
        System.out.println(question);
        assertNotNull(question);
    }

    @Test
    public void removeQuestion() {
    }
}