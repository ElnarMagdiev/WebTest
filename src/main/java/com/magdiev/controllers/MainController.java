package com.magdiev.controllers;

import com.magdiev.models.Question;
import com.magdiev.services.AnswerService;
import com.magdiev.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

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

    @RequestMapping(value = "/")
    public String index(Model model) {
        List<Question> listQuestion = questionService.allQuestions();

        for (Question question: listQuestion) {
            question.setAnswers(answerService.getAnswersByQuestionId(question.getId()));
        }

        model.addAttribute("title", "Web testing");
        model.addAttribute("listQuestion", listQuestion);

        return "index";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String submit(HttpServletRequest request) {
       String[] question = request.getParameterValues("questionId");
       int count = 0;
        for (String questionId: question) {
            int correctAnswerId = answerService.findCorrectAnswerByQuestionId(Integer.parseInt(questionId));
            if (correctAnswerId == Integer.parseInt(request.getParameter("question_" + questionId)))
            count++;
        }
        request.setAttribute("count", count);
        return "result";
    }
}
