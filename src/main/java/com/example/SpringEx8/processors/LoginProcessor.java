package com.example.SpringEx8.processors;

import com.example.SpringEx8.services.LoggedUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String username;
    private String password;
    private LoggedUserManagementService loggedUserManagementService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public boolean login() {
        if (username.equals("natalie") && password.equals("password")) {
            loggedUserManagementService.setUsername(username);
            return true;
        }

        return false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
