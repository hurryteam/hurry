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
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "6") Integer size,
                             Map<String, Object> map){
        PageRequest request = PageRequest.of(page-1, size);
        Page<Question> questions = questionService.findAll(request);
        map.put("questions", questions);
        map.put("size", size);
        //当前页数
        map.put("curPage", page);
        return new ModelAndView("question/list", map);
    }

    /**
     * 删除问题
     * @param questionId
     * @return
     */
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("questionId") Integer questionId,
                               Map<String, Object> map){
        Question q = questionService.findByQuestionId(questionId);
        if (q == null){
            map.put("msg", "问题Id不存在");
            map.put("url", "/hurry/manager/question/list");
            return new ModelAndView("common/error", map);
        }
        questionService.removeQuestion(questionId);
        map.put("msg", "问题删除成功");
        map.put("url", "/hurry/manager/question/list");
        return new ModelAndView("common/success", map);
    }
}
