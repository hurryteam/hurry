package com.scnu.hurry.controller.manager;


import com.scnu.hurry.Form.QuestionFrom;
import com.scnu.hurry.entity.Model;
import com.scnu.hurry.entity.Question;
import com.scnu.hurry.service.QuestionService;
import com.scnu.hurry.service.ReplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/manager/question")
public class QuestionManager {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private ReplyService replyService;

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
        //删除回复
        replyService.removeReplyByQuestionId(q.getQuestionId());
        //删除问题
        questionService.removeQuestion(questionId);
        map.put("msg", "问题删除成功");
        map.put("url", "/hurry/manager/question/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 保存问题
     * @param question
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid Question question,
                               BindingResult bindingResult,
                               Map<String, Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/hurry/manager/question/list");
            return new ModelAndView("common/error", map);
        }
        Question q = new Question();
        BeanUtils.copyProperties(question, q);
        questionService.addQuestion(q);
        map.put("msg", "更新问题成功");
        map.put("url", "/hurry/manager/question/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/update")
    public ModelAndView update(@RequestParam("questionId") Integer questionId,
                               Map<String, Object> map){
        Question q = questionService.findByQuestionId(questionId);
        if (q == null){
            map.put("msg","问题不存在");
            map.put("url", "/hurry/manager/question/list");
            return new ModelAndView("common/error", map);
        }
        map.put("question", q);
        return new ModelAndView("question/update", map);
    }

}
