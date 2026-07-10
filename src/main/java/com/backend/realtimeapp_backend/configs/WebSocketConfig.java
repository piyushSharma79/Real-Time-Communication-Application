package com.backend.realtimeapp_backend.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { //registry generally store registrations
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("http://loclhost:8080") //allowed request from url
                .withSockJS(); //enable socket support -> another technique to keep real-time communication working when websocket is unavailable
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); //every msg begin with /app and route to message mapping
        registry.enableSimpleBroker("/topic", "/queue"); //anything start with them do not send them to controller, let msg broker deliver it
    }
}
