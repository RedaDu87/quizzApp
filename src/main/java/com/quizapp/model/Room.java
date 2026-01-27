package com.quizapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "rooms")
public class Room {
    @Id
    private String id;
    private String roomCode;
    private String creatorName;
    private LocalDateTime createdAt;
    private boolean started;
    private int currentQuestionIndex;
    private List<String> playerNames;
    private List<Question> questions;
    private String currentTurnPlayer;
    private List<ChatMessage> chatMessages;
    private List<PlayerScore> playerScores;

    public Room() {
        this.createdAt = LocalDateTime.now();
        this.started = false;
        this.currentQuestionIndex = 0;
        this.playerNames = new ArrayList<>();
        this.chatMessages = new ArrayList<>();
        this.playerScores = new ArrayList<>();
        this.questions = new ArrayList<>();
    }

    @Data
    public static class ChatMessage {
        private String playerName;
        private String message;
        private LocalDateTime timestamp;

        public ChatMessage(String playerName, String message) {
            this.playerName = playerName;
            this.message = message;
            this.timestamp = LocalDateTime.now();
        }
    }

    @Data
    public static class PlayerScore {
        private String playerName;
        private int score;
        private List<Integer> answers;

        public PlayerScore(String playerName) {
            this.playerName = playerName;
            this.score = 0;
            this.answers = new ArrayList<>();
        }
    }
}
