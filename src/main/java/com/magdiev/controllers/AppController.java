package com.magdiev.controllers;

import com.magdiev.exceptions.NotFoundException;
import com.magdiev.models.Answer;
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

        return new RedirectView("/");
    }

    @GetMapping("{id}/answers")
    public ModelAndView addAnswers(@PathVariable String id){
        if (id.isEmpty()) throw new NotFoundException();
        Question question = questionService.getQuestionById(Integer.parseInt(id));
        question.setAnswers(answerService.getAnswersByQuestionId(question.getId()));
        ModelAndView modelAndView = new ModelAndView("answer-add");
        modelAndView.addObject(question);

        return modelAndView;
    }

    @PostMapping("{id}/answers")
    public RedirectView addAnswers(HttpServletRequest request){
        for (int i = 0; i < 4; i++) {
          String s = request.getParameter("id_" + i);

          String content = request.getParameter("answer_content_" + i);
          int id = request.getParameter("id_" + i) != null ? Integer.parseInt(request
                                                                                    .getParameter("id_" + i)) : -1;
          boolean isCorrect = request.getParameter("answer_isCorrect_" + i) != null;
        }

        return new RedirectView("/");
    }
}
