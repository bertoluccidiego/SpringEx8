package com.example.SpringEx8.controllers;

import com.example.SpringEx8.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout,
                       Model model) {
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

       String username = loggedUserManagementService.getUsername();
        if (username == null) {
            return "redirect:/";
       }

        model.addAttribute("username", username);
        return "main.html";
    }
}
