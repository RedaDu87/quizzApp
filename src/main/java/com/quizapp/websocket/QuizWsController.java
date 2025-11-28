package com.quizapp.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class QuizWsController {

    @MessageMapping("/nextQuestion")
    @SendTo("/topic/progress")
    public int broadcastNextQuestion(int nextIndex) {
        return nextIndex;
    }
}
