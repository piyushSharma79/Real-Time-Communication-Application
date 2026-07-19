package com.backend.realtimeapp_backend.controllers;

import com.backend.realtimeapp_backend.dtos.ChatMessageRequest;
import com.backend.realtimeapp_backend.services.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private final MessageService messageService;
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }
    @MessageMapping("/chat.send")
    public void sendMessage(ChatMessageRequest request){
        messageService.sendMessage(request);
    }
}
