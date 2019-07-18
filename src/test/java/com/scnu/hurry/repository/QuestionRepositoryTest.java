package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Question;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void TestFindAllQuestion() {
        Question question = new Question();
        question.setUserId(1);
        question.setQuestionId(null);
        question.setQuestionContent("This is a question");
        try {
            questionRepository.saveAndFlush(question);
            List<Question> l = questionRepository.findAll(PageRequest.of(0, 1)).getContent();
            assertEquals(l.get(0).getQuestionContent(), question.getQuestionContent());
        } finally {
            questionRepository.delete(question);
        }
    }

    @Test
    public void TestFindQuestion() {
        Question question = new Question();
        question.setUserId(1);
        question.setQuestionId(null);
        question.setQuestionContent("This is a question");
        try {
            questionRepository.saveAndFlush(question);
            List<Question> l = questionRepository.findByUserId(1, PageRequest.of(0, 2)).getContent();
            System.out.println(l);
            assertEquals(l.get(0).getQuestionContent(), "This is a question");
        } finally {
            questionRepository.delete(question);
        }
    }
}
