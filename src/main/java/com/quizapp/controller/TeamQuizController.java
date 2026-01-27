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
    public String showRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "team/rooms";
    }

    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> createRoom(@RequestParam String playerName, HttpSession session) {
        Room room = roomService.createRoom(playerName);
        session.setAttribute("playerName", playerName);
        session.setAttribute("currentRoomCode", room.getRoomCode());
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("roomCode", room.getRoomCode());
        return response;
    }

    @GetMapping("/room/{roomCode}")
    public String showRoom(@PathVariable String roomCode, @RequestParam(required = false) String playerName, 
                          Model model, HttpSession session) {
        Optional<Room> roomOpt = roomService.getRoomByCode(roomCode);
        if (roomOpt.isEmpty()) {
            return "redirect:/team/rooms?error=notfound";
        }
        
        Room room = roomOpt.get();
        
        // If playerName provided, join the room
        if (playerName != null && !playerName.isEmpty()) {
            Optional<Room> joinedRoom = roomService.joinRoom(roomCode, playerName);
            if (joinedRoom.isPresent()) {
                session.setAttribute("playerName", playerName);
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
    public String showJoinPage(@PathVariable String roomCode, Model model) {
        Optional<Room> roomOpt = roomService.getRoomByCode(roomCode);
        if (roomOpt.isEmpty()) {
            return "redirect:/team/rooms?error=notfound";
        }
        model.addAttribute("roomCode", roomCode);
        return "team/join";
    }

    @PostMapping("/start/{roomCode}")
    @ResponseBody
    public Map<String, Object> startRoom(@PathVariable String roomCode) {
        Optional<Room> room = roomService.startRoom(roomCode);
        Map<String, Object> response = new HashMap<>();
        response.put("success", room.isPresent());
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
        if (playerName == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            return response;
        }
        
        Optional<Room> room = roomService.addChatMessage(roomCode, playerName, message);
        Map<String, Object> response = new HashMap<>();
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
