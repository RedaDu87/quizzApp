package com.quizapp.controller;

import com.quizapp.model.Room;
import com.quizapp.service.RoomService;
import jakarta.servlet.http.HttpSession;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/team")
public class TeamQuizController {
    private final RoomService roomService;

    public TeamQuizController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public String showRooms(Model model, HttpSession session) {
        // Check authentication
        if (session.getAttribute("AUTH") == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("rooms", roomService.getAllRooms());
        return "team/rooms";
    }

    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> createRoom(@RequestParam String playerName, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        
        // Check authentication
        if (session.getAttribute("AUTH") == null) {
            response.put("success", false);
            response.put("error", "Authentication required");
            return response;
        }
        
        // Validate and sanitize player name
        if (playerName == null || playerName.trim().isEmpty()) {
            response.put("success", false);
            response.put("error", "Player name cannot be empty");
            return response;
        }
        
        // Sanitize player name - remove HTML tags and limit length
        String sanitizedName = playerName.replaceAll("<[^>]*>", "").trim();
        if (sanitizedName.length() > 20) {
            sanitizedName = sanitizedName.substring(0, 20);
        }
        
        Room room = roomService.createRoom(sanitizedName);
        session.setAttribute("playerName", sanitizedName);
        session.setAttribute("currentRoomCode", room.getRoomCode());
        
        response.put("success", true);
        response.put("roomCode", room.getRoomCode());
        return response;
    }

    @GetMapping("/room/{roomCode}")
    public String showRoom(@PathVariable String roomCode, @RequestParam(required = false) String playerName, 
                          Model model, HttpSession session) {
        // Check authentication
        if (session.getAttribute("AUTH") == null) {
            return "redirect:/login";
        }
        
        Optional<Room> roomOpt = roomService.getRoomByCode(roomCode);
        if (roomOpt.isEmpty()) {
            return "redirect:/team/rooms?error=notfound";
        }
        
        Room room = roomOpt.get();
        
        // If playerName provided, join the room
        if (playerName != null && !playerName.isEmpty()) {
            // Sanitize player name
            String sanitizedName = playerName.replaceAll("<[^>]*>", "").trim();
            if (sanitizedName.length() > 20) {
                sanitizedName = sanitizedName.substring(0, 20);
            }
            
            Optional<Room> joinedRoom = roomService.joinRoom(roomCode, sanitizedName);
            if (joinedRoom.isPresent()) {
                session.setAttribute("playerName", sanitizedName);
                session.setAttribute("currentRoomCode", roomCode);
                room = joinedRoom.get();
            } else {
                return "redirect:/team/rooms?error=joinfailed";
            }
        }
        
        String sessionPlayerName = (String) session.getAttribute("playerName");
        if (sessionPlayerName == null) {
            return "redirect:/team/join/" + roomCode;
        }
        
        model.addAttribute("room", room);
        model.addAttribute("playerName", sessionPlayerName);
        model.addAttribute("isCreator", room.getCreatorName().equals(sessionPlayerName));
        
        return "team/room";
    }

    @GetMapping("/join/{roomCode}")
    public String showJoinPage(@PathVariable String roomCode, Model model, HttpSession session) {
        // Check authentication
        if (session.getAttribute("AUTH") == null) {
            return "redirect:/login";
        }
        
        Optional<Room> roomOpt = roomService.getRoomByCode(roomCode);
        if (roomOpt.isEmpty()) {
            return "redirect:/team/rooms?error=notfound";
        }
        model.addAttribute("roomCode", roomCode);
        return "team/join";
    }

    @PostMapping("/start/{roomCode}")
    @ResponseBody
    public Map<String, Object> startRoom(@PathVariable String roomCode, HttpSession session) {
        String playerName = (String) session.getAttribute("playerName");
        Optional<Room> roomOpt = roomService.getRoomByCode(roomCode);
        
        Map<String, Object> response = new HashMap<>();
        if (roomOpt.isEmpty()) {
            response.put("success", false);
            response.put("error", "Room not found");
            return response;
        }
        
        Room room = roomOpt.get();
        if (!room.getCreatorName().equals(playerName)) {
            response.put("success", false);
            response.put("error", "Only the room creator can start the quiz");
            return response;
        }
        
        Optional<Room> startedRoom = roomService.startRoom(roomCode);
        response.put("success", startedRoom.isPresent());
        return response;
    }

    @PostMapping("/answer/{roomCode}")
    @ResponseBody
    public Map<String, Object> submitAnswer(@PathVariable String roomCode, 
                                           @RequestParam int answerIndex,
                                           HttpSession session) {
        String playerName = (String) session.getAttribute("playerName");
        if (playerName == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("error", "Not logged in");
            return response;
        }
        
        Optional<Room> room = roomService.submitAnswer(roomCode, playerName, answerIndex);
        Map<String, Object> response = new HashMap<>();
        response.put("success", room.isPresent());
        if (room.isPresent()) {
            response.put("room", room.get());
        }
        return response;
    }

    @PostMapping("/chat/{roomCode}")
    @ResponseBody
    public Map<String, Object> sendChatMessage(@PathVariable String roomCode,
                                               @RequestParam String message,
                                               HttpSession session) {
        String playerName = (String) session.getAttribute("playerName");
        Map<String, Object> response = new HashMap<>();
        
        if (playerName == null) {
            response.put("success", false);
            return response;
        }
        
        // Validate and sanitize message
        if (message == null || message.trim().isEmpty()) {
            response.put("success", false);
            response.put("error", "Message cannot be empty");
            return response;
        }
        
        String sanitizedMessage = message.replaceAll("<[^>]*>", "").trim();
        if (sanitizedMessage.length() > 500) {
            sanitizedMessage = sanitizedMessage.substring(0, 500);
        }
        
        Optional<Room> room = roomService.addChatMessage(roomCode, playerName, sanitizedMessage);
        response.put("success", room.isPresent());
        return response;
    }

    @GetMapping("/state/{roomCode}")
    @ResponseBody
    public Map<String, Object> getRoomState(@PathVariable String roomCode) {
        Optional<Room> roomOpt = roomService.getRoomByCode(roomCode);
        Map<String, Object> response = new HashMap<>();
        if (roomOpt.isPresent()) {
            response.put("success", true);
            response.put("room", roomOpt.get());
        } else {
            response.put("success", false);
        }
        return response;
    }

    // WebSocket message mappings
    @MessageMapping("/room/{roomCode}/answer")
    @SendTo("/topic/room/{roomCode}")
    public Room handleAnswer(@DestinationVariable String roomCode, Map<String, Object> payload) {
        String playerName = (String) payload.get("playerName");
        int answerIndex = (int) payload.get("answerIndex");
        Optional<Room> room = roomService.submitAnswer(roomCode, playerName, answerIndex);
        return room.orElse(null);
    }

    @MessageMapping("/room/{roomCode}/chat")
    @SendTo("/topic/room/{roomCode}/chat")
    public Room.ChatMessage handleChat(@DestinationVariable String roomCode, Map<String, Object> payload) {
        String playerName = (String) payload.get("playerName");
        String message = (String) payload.get("message");
        roomService.addChatMessage(roomCode, playerName, message);
        return new Room.ChatMessage(playerName, message);
    }
}
