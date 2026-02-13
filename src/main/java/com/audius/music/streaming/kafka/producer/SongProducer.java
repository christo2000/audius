package com.audius.music.streaming.kafka.producer;

import com.audius.music.streaming.kafka.interfaces.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SongProducer implements Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SongProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(String topic, String key, String value) {
        kafkaTemplate.send(topic, key, value);
        return "Message sent to topic: " + topic + " with key: " + key + " and value: " + value;
    }

}
