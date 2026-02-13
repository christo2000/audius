package com.audius.music.streaming.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SongConsumer {

    private String message;

    @KafkaListener(topics = "audius", groupId = "audius-song-service")
    public void consume(String content) {
        System.out.println("Received message: " + content);
        this.message = content;
    }

    public String getMessage() {
        System.out.println("Received message: " + message);
        return "Message received: " + message;
    }

}
