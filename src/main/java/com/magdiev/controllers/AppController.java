package com.magdiev.controllers;

import com.magdiev.exceptions.NotFoundException;
import com.magdiev.models.Question;
import com.magdiev.services.AnswerService;
import com.magdiev.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/question")
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

    @GetMapping("/add")
    public ModelAndView addQuestion() {
        return new ModelAndView("question-add");
    }

    @PostMapping(value = "/add")
    public RedirectView addQuestion(HttpServletRequest request) {

        String questionContent = request.getParameter("content");
        Question question = new Question(questionContent);
        questionService.add(question);

        for (int i = 1; i < 5; i++) {
            String answerContent = request.getParameter("answer_content_" + i);
            String isCorrect = request.getParameter("answer_isCorrect_" + i);
        }

        return new RedirectView("/");
    }

    @GetMapping("{id}/answers")
    public ModelAndView addAnswers(@PathVariable String id){
        if (id.isEmpty()) throw new NotFoundException();
        Question question = questionService.getQuestionById(Integer.parseInt(id));
        question.setAnswers(answerService.getAnswersByQuestionId(question.getId()));
        ModelAndView modelAndView = new ModelAndView("question-edit");
        modelAndView.addObject(question);

        return modelAndView;
    }
}
