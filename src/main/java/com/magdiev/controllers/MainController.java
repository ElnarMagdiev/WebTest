package com.magdiev.controllers;

import com.magdiev.dao.QuestionDao;
import com.magdiev.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private QuestionDao dao;

    @RequestMapping("/")
    public String index(Model model) {
        List<Question> listQuestion = dao.allQuestions();
        model.addAttribute("title", "Web testing");
        model.addAttribute("listQuestion", listQuestion);
        return "index";
    }
}
