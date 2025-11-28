package com.quizapp.state;

import com.quizapp.model.Question;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class QuizState {

    public List<Question> questions = new ArrayList<>();
    public int index = 0;
    public List<Integer> answers = new ArrayList<>();
    public int score = 0;
    public boolean started = false;

}
