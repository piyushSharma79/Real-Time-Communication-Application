package com.backend.realtimeapp_backend.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatMessageResponse {
    private Long chatRoomId;
    private String message;
    private String senderName;
    private LocalDateTime createdAt;
}
