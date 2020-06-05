package com.magdiev.controllers;

import com.magdiev.models.User;
import com.magdiev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
       User userDb = userService.findUserByUsername(user.getUsername());

        if (userDb != null) {
            model.addAttribute("message", "Такой пользователь уже существует");
            return "registration";
        }
        userService.add(user);
        return "redirect:/login";
    }
}
