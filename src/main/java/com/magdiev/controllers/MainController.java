package com.magdiev.controllers;

import com.magdiev.dao.AnswerDao;
import com.magdiev.dao.QuestionDao;
import com.magdiev.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;

    @RequestMapping(value = "/")
    public String index(Model model) {
        List<Question> listQuestion = questionDao.allQuestions();
        model.addAttribute("title", "Web testing");
        model.addAttribute("listQuestion", listQuestion);

        return "index";
    }
}
