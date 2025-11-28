package com.quizapp.service;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        List<Question> reda = repo.findByOwner("REDA");
        List<Question> romaisa = repo.findByOwner("ROMAISA");

        Collections.shuffle(reda);
        Collections.shuffle(romaisa);

        // On prend MIN(10, nombre disponible)
        int limitReda = Math.min(10, reda.size());
        int limitRomaisa = Math.min(10, romaisa.size());

        reda = reda.subList(0, limitReda);
        romaisa = romaisa.subList(0, limitRomaisa);

        // Fusion
        List<Question> all = new ArrayList<>();
        all.addAll(reda);
        all.addAll(romaisa);

        // Mélanger
        Collections.shuffle(all);

        return all;
    }

}
