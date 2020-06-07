package com.magdiev.controllers;

import com.magdiev.models.Question;
import com.magdiev.models.Result;
import com.magdiev.models.User;
import com.magdiev.services.AnswerService;
import com.magdiev.services.QuestionService;
import com.magdiev.services.ResultService;
import com.magdiev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    private QuestionService questionService;
    private AnswerService answerService;
    private UserService userService;
    private ResultService resultService;

    @Autowired
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "test")
    public String webTest(Model model) {
        List<Question> listQuestion = questionService.allQuestions();

        for (Question question: listQuestion) {
            question.setAnswers(answerService.getAnswersByQuestionId(question.getId()));
        }

        model.addAttribute("title", "Web testing");
        model.addAttribute("listQuestion", listQuestion);

        return "web-test";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String submit(HttpServletRequest request) {
        String[] question = request.getParameterValues("questionId");
        int count = 0;

        for (String questionId: question) {
            int correctAnswerId = answerService.findCorrectAnswerByQuestionId(Integer.parseInt(questionId));
            String answerId = request.getParameter("question_" + questionId);
            if (answerId != null && correctAnswerId == Integer.parseInt(answerId))
                count++;
        }
        boolean completed = question.length == count;

        User user = userService.findUserByUsername(userService.getCurrentUsername());
        Result result = new Result(user.getId(), count, completed);
        resultService.add(result);

        request.setAttribute("count", count);
        request.setAttribute("completed", completed);
        request.setAttribute("username", user.getUsername());
        request.setAttribute("betterYou", resultService.findBetterResults(count));
        request.setAttribute("worseThanYou", resultService.findWorseResults(count));

        return "result";
    }
}
