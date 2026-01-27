package com.quizapp.service;

import com.quizapp.model.Question;
import com.quizapp.model.Room;
import com.quizapp.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private static final int QUIZ_QUESTIONS_COUNT = 20;
    
    private final RoomRepository roomRepository;
    private final QuestionService questionService;
    private final Random random = new Random();

    public RoomService(RoomRepository roomRepository, QuestionService questionService) {
        this.roomRepository = roomRepository;
        this.questionService = questionService;
    }

    public Room createRoom(String creatorName) {
        Room room = new Room();
        room.setRoomCode(generateRoomCode());
        room.setCreatorName(creatorName);
        room.getPlayerNames().add(creatorName);
        
        // Initialize player score for creator
        Room.PlayerScore creatorScore = new Room.PlayerScore(creatorName);
        room.getPlayerScores().add(creatorScore);
        
        room.setCurrentTurnPlayer(creatorName);
        
        return roomRepository.save(room);
    }

    public Optional<Room> joinRoom(String roomCode, String playerName) {
        Optional<Room> roomOpt = roomRepository.findByRoomCode(roomCode);
        if (roomOpt.isPresent()) {
            Room room = roomOpt.get();
            if (!room.isStarted() && !room.getPlayerNames().contains(playerName)) {
                room.getPlayerNames().add(playerName);
                
                // Initialize player score
                Room.PlayerScore playerScore = new Room.PlayerScore(playerName);
                room.getPlayerScores().add(playerScore);
                
                return Optional.of(roomRepository.save(room));
            }
        }
        return Optional.empty();
    }

    public Optional<Room> startRoom(String roomCode) {
        Optional<Room> roomOpt = roomRepository.findByRoomCode(roomCode);
        if (roomOpt.isPresent()) {
            Room room = roomOpt.get();
            if (!room.isStarted()) {
                room.setStarted(true);
                List<Question> questions = questionService.get20Questions();
                room.setQuestions(questions);
                room.setCurrentQuestionIndex(0);
                return Optional.of(roomRepository.save(room));
            }
        }
        return Optional.empty();
    }

    public Optional<Room> getRoomByCode(String roomCode) {
        return roomRepository.findByRoomCode(roomCode);
    }

    public Optional<Room> submitAnswer(String roomCode, String playerName, int answerIndex) {
        Optional<Room> roomOpt = roomRepository.findByRoomCode(roomCode);
        if (roomOpt.isPresent()) {
            Room room = roomOpt.get();
            
            // Check if it's this player's turn
            if (!room.getCurrentTurnPlayer().equals(playerName)) {
                return Optional.empty();
            }
            
            // Get current question
            Question currentQuestion = room.getQuestions().get(room.getCurrentQuestionIndex());
            
            // Find player score
            Room.PlayerScore playerScore = room.getPlayerScores().stream()
                .filter(ps -> ps.getPlayerName().equals(playerName))
                .findFirst()
                .orElse(null);
            
            if (playerScore != null) {
                playerScore.getAnswers().add(answerIndex);
                
                // Check if answer is correct
                if (answerIndex == currentQuestion.getCorrectIndex()) {
                    playerScore.setScore(playerScore.getScore() + 1);
                }
            }
            
            // Switch turn to next player
            int currentPlayerIndex = room.getPlayerNames().indexOf(playerName);
            int nextPlayerIndex = (currentPlayerIndex + 1) % room.getPlayerNames().size();
            room.setCurrentTurnPlayer(room.getPlayerNames().get(nextPlayerIndex));
            
            // Move to next question after all players answered current question
            int currentIndex = room.getCurrentQuestionIndex();
            boolean allAnswered = room.getPlayerScores().stream()
                .allMatch(ps -> ps.getAnswers().size() > currentIndex);
            
            if (allAnswered && currentIndex < QUIZ_QUESTIONS_COUNT - 1) {
                room.setCurrentQuestionIndex(currentIndex + 1);
                // Reset turn to first player for new question
                room.setCurrentTurnPlayer(room.getPlayerNames().get(0));
            }
            
            return Optional.of(roomRepository.save(room));
        }
        return Optional.empty();
    }

    public Optional<Room> addChatMessage(String roomCode, String playerName, String message) {
        Optional<Room> roomOpt = roomRepository.findByRoomCode(roomCode);
        if (roomOpt.isPresent()) {
            Room room = roomOpt.get();
            Room.ChatMessage chatMessage = new Room.ChatMessage(playerName, message);
            room.getChatMessages().add(chatMessage);
            return Optional.of(roomRepository.save(room));
        }
        return Optional.empty();
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll().stream()
            .filter(room -> !room.isStarted() || room.getCurrentQuestionIndex() < QUIZ_QUESTIONS_COUNT)
            .collect(Collectors.toList());
    }

    private String generateRoomCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String code;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
            code = sb.toString();
        } while (roomRepository.findByRoomCode(code).isPresent());
        return code;
    }
}
