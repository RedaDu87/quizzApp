package com.quizapp.controller;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;
import com.quizapp.state.QuizState;
import com.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizState quizState;

    @GetMapping("/start")
    public String start(Model model) {

        quizState.started = true;
        quizState.index = 0;
        quizState.score = 0;
        quizState.answers = new ArrayList<>();

        // Récupérer 20 questions RANDOM
        quizState.questions = questionService.get20Questions();

        return "quiz/start";
    }

    @GetMapping("/question")
    public String question(Model model) {

        if (!quizState.started || quizState.questions == null)
            return "redirect:/quiz/start";

        if (quizState.index >= quizState.questions.size())
            return "redirect:/quiz/result";

        Question q = quizState.questions.get(quizState.index);

        model.addAttribute("q", q);
        model.addAttribute("num", quizState.index + 1);

        return "quiz/question";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam int answer) {

        if (!quizState.started)
            return "redirect:/quiz/start";

        Question q = quizState.questions.get(quizState.index);

        quizState.answers.add(answer);

        if (answer == q.getCorrectIndex())
            quizState.score++;

        quizState.index++;

        if (quizState.index >= quizState.questions.size())
            return "redirect:/quiz/result";

        return "redirect:/quiz/question";
    }

    @GetMapping("/result")
    public String result(Model model) {

        model.addAttribute("score", quizState.score);
        model.addAttribute("questions", quizState.questions);
        model.addAttribute("userAnswers", quizState.answers);

        return "quiz/result";
    }
}
