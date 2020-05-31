package com.magdiev.controllers;

import com.magdiev.models.Question;
import com.magdiev.services.AnswerService;
import com.magdiev.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AppController {

    private QuestionService questionService;
    private AnswerService answerService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping(value = "/question/add" , method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id) {

        return "";
    }
    @RequestMapping(value = "/question/edit" , method = RequestMethod.POST)
    public String edit(@ModelAttribute("question") Question question) {
        questionService.update(question);
        return "/";
    }
}
