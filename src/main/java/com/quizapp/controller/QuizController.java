package com.quizapp.controller;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;
import com.quizapp.state.QuizState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizState quizState;

    @Autowired
    private SimpMessagingTemplate messaging;

    @GetMapping("/start")
    public String start(Model model) {

        quizState.started = true;
        quizState.index = 0;
        quizState.score = 0;
        quizState.answers = new ArrayList<>();

        List<Question> reda = questionRepository.findByOwner("REDA");
        List<Question> romaisa = questionRepository.findByOwner("ROMAISA");

        Collections.shuffle(reda);
        Collections.shuffle(romaisa);

        List<Question> qs = new ArrayList<>();
        qs.addAll(reda.stream().limit(10).toList());
        qs.addAll(romaisa.stream().limit(10).toList());
        Collections.shuffle(qs);

        quizState.questions = qs;

        // Broadcast "question 1"
        messaging.convertAndSend("/topic/progress", quizState.index);

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

        // 🌸 Déterminer le thème
        String theme = q.getOwner().equalsIgnoreCase("REDA") ? "pink" : "blue";
        model.addAttribute("theme", theme);

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

        // 🔥 Notifier tout le monde (passer à question suivante)
        messaging.convertAndSend("/topic/progress", quizState.index);

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
