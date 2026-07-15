package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.dtos.ChatMessageRequest;
import com.backend.realtimeapp_backend.dtos.ChatMessageResponse;

public interface MessageService {
    ChatMessageResponse sendMessage(ChatMessageRequest request);

}
