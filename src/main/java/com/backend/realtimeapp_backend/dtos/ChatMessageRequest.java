package com.backend.realtimeapp_backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChatMessageRequest {
    @NotNull
    private String message;

    @NotBlank
    private long chatRoomId;
}
