package com.quizapp.service;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository repo;

    public Question save(Question q) { return repo.save(q); }

    public List<Question> getAll() { return repo.findAll(); }

    public Question getById(String id) { return repo.findById(id).orElse(null); }

    public void delete(String id) { repo.deleteById(id); }

    public List<Question> get20Questions() {

        List<Question> all = repo.findAll();

        // Mélanger tout
        Collections.shuffle(all);

        // limiter à 20
        int limit = Math.min(20, all.size());

        return all.subList(0, limit);
    }
}
