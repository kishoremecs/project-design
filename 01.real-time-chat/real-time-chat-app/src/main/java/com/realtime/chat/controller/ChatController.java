package com.realtime.chat.controller;

import com.realtime.chat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage") // Client sends messages to /app/sendMessage
    @SendTo("/topic/public") // Messages will be broadcasted to this topic
    public ChatMessage sendMessage(ChatMessage message) {
        return message; // Returns message to all subscribers
    }
}
