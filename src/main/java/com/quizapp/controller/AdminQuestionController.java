package com.quizapp.controller;

import com.quizapp.model.Question;
import com.quizapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/questions")
public class AdminQuestionController {

    private final QuestionService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("questions", service.getAll());
        return "admin/questions-list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("question", new Question());
        return "admin/questions-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Question question) {
        service.save(question);
        return "redirect:/admin/questions";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("question", service.getById(id));
        return "admin/questions-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/admin/questions";
    }
}
