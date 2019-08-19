package com.scnu.hurry.controller.manager;


import com.scnu.hurry.entity.Question;
import com.scnu.hurry.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/manager/question")
public class QuestionManager {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "index",defaultValue = "0") Integer index,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String, Object> map){
        PageRequest request = PageRequest.of(index, size);
        Page<Question> questions = questionService.findAll(request);
        map.put("questions", questions);
        return new ModelAndView("question/list", map);
    }
}
