package com.example.SpringEx8.controllers;

import com.example.SpringEx8.processors.LoginProcessor;
import com.example.SpringEx8.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class.getName());
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor){
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        if (loginProcessor.login())  {
            return "redirect:/main";
        }

        model.addAttribute("message", "Login failed");
        return "login.html";
    }
}
