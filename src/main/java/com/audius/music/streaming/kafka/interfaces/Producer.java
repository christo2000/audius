package com.audius.music.streaming.kafka.interfaces;

import org.springframework.http.ResponseEntity;

public interface Producer {
    String sendMessage(String topic, String key, String value);
}
