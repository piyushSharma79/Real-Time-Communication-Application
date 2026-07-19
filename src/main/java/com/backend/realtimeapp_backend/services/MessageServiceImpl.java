package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.dtos.ChatMessageRequest;
import com.backend.realtimeapp_backend.dtos.ChatMessageResponse;
import com.backend.realtimeapp_backend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl implements MessageService{


    private final CurrentUserService currentUserService;
    private final SimpMessagingTemplate messagingTemplate;
    public MessageServiceImpl(CurrentUserService currentUserService, SimpMessagingTemplate messagingTemplate) {
        this.currentUserService = currentUserService;
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public ChatMessageResponse sendMessage(ChatMessageRequest request) {

        User sender = currentUserService.getCurrentUser();
        ChatMessageResponse response = new ChatMessageResponse();
        response.setMessage(request.getMessage());
        response.setSenderName(sender.getName());
        response.setChatRoomId(request.getChatRoomId());
        response.setCreatedAt(LocalDateTime.now());
        String destination = "/topic/chat/" + request.getChatRoomId();

        messagingTemplate.convertAndSend(destination, response);

        return response;
    }
}
