package com.quizapp.state;

import com.quizapp.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuizState {

    public List<Question> questions;
    public int index = 0;
    public List<Integer> answers = new ArrayList<>();
    public int score = 0;
    public boolean started = false;
}
