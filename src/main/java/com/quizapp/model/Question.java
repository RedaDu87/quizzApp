package com.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "questions")
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    private String id;

    private String owner;      // "REDA" ou "ROMAISA"
    private String question;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private int correctIndex; // 0 à 3


}
