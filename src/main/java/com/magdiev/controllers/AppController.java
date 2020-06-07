package com.magdiev.controllers;

import com.magdiev.exceptions.NotFoundException;
import com.magdiev.models.Answer;
import com.magdiev.models.Question;
import com.magdiev.services.AnswerService;
import com.magdiev.services.QuestionService;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/questions")
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

    @GetMapping
    public ModelAndView questionList() {
        List<Question> listQuestion = questionService.allQuestions();

        for (Question question: listQuestion) {
            question.setAnswers(answerService.getAnswersByQuestionId(question.getId()));
        }
        ModelAndView modelAndView = new ModelAndView("questions");
        modelAndView.addObject("listQuestion", listQuestion);

        return modelAndView;
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

        return new RedirectView("/questions");
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
        int questionId = Integer.parseInt(request.getParameter("id_question"));
        for (int i = 0; i < 4; i++) {
          String content = request.getParameter("answer_content_" + i);
          int id = request.getParameter("id_" + i) != "" ? Integer.parseInt(request
                                                                             .getParameter("id_" + i)) : -1;
          String correctAnswer = null;
          boolean isCorrect = false;
          if ((correctAnswer = request.getParameter("answer_isCorrect")) != null) {
              if (Integer.parseInt(correctAnswer) == i) isCorrect = true;
          }

          if (id != -1 && content != null) {
              Answer answer = answerService.getAnswerById(id);
              answer.setId_question(questionId);
              answer.setCorrect(isCorrect);
              answer.setContent(content);
              answerService.update(answer);
          } else if (content != null) {
              Answer answer = new Answer(questionId, content, isCorrect);
              answerService.add(answer);
          }
        }

        return new RedirectView("/questions");
    }
}
