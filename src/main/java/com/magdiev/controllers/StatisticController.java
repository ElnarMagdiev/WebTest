package com.magdiev.controllers;

import com.magdiev.services.ResultService;
import com.magdiev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/statistic")
public class StatisticController {

    private ResultService resultService;
    private UserService userService;

    @Autowired
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String statistic(Model model) {

        model.addAttribute("allUsersCount", userService.getUserList().size());
        model.addAttribute("resultsCount", resultService.getAllResults().size());
        model.addAttribute("completeTest", resultService.getCompletedResults().size());

        return "statistic";
    }


}
