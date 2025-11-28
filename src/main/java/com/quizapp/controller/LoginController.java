package com.quizapp.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @Value("${app.login.password}")
    private String appPassword;

    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(String password, HttpSession session, Model model) {

        if (password != null && password.equals(appPassword)) {
            session.setAttribute("AUTH", true);
            return "redirect:/quiz/start";
        }

        model.addAttribute("error", "Mot de passe incorrect");
        return "auth/login";
    }
}
