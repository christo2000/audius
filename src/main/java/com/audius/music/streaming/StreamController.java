package com.audius.music.streaming.kafka;

//import com.audius.music.config.kafka.TopicConfiguration;
import com.audius.music.streaming.kafka.consumer.SongConsumer;
import com.audius.music.streaming.kafka.producer.SongProducer;
import com.audius.music.utils.TrackDto;
import com.audius.music.utils.controller.MusicController;
import com.audius.music.utils.entity.TrackEntity;
import com.audius.music.utils.service.MusicService;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stream")
public class StreamController {

    private final Logger logger = LoggerFactory.getLogger(MusicService.class);
    private SongProducer songProducer;
//    private TopicConfiguration topicConfiguration;
    private SongConsumer songConsumer;
    private MusicService musicService;
    private JsonNode mapper;

    StreamController(SongProducer songProducer, SongConsumer songConsumer , MusicService musicService//, TopicConfiguration topicConfiguration
    ){
        this.songProducer = songProducer;
//        this.topicConfiguration = topicConfiguration;
        this.songConsumer = songConsumer;
        this.musicService = musicService;
    }

    @PostMapping("/send/{topic}/{key}/{value}")
    public ResponseEntity<String> sendMessages(@PathVariable String topic, @PathVariable String key, @PathVariable String value) {
        return new ResponseEntity<String>(songProducer.sendMessage(topic, key, value), HttpStatus.OK);
    }

//    @PostMapping("/addTopic/{topic}/{numPartitions}/{value}")
//    public NewTopic newTopic(@PathVariable String topic, @PathVariable Integer numPartitions, @PathVariable Short value) {
//        return topicConfiguration.topic(topic, numPartitions, value);
//    }

    @GetMapping("/getMessages/{topic}/{key}/{value}")
    public ResponseEntity<String> getMessages() {
        return new ResponseEntity<>(songConsumer.getMessage(), HttpStatus.OK);
    }

    @PostMapping("/getSongs/{page}/{pageSize}")
        public ResponseEntity<String> getSongs(@PathVariable Integer page, @PathVariable Integer pageSize) {
        List<TrackDto> fetchedTracks = musicService.paginatedTrackData(page, pageSize);
//        logger.info(" Input values"+ fetchedTracks.stream().toList().toString());
        String finalResponse = songProducer.sendMessage("audius", "intics", fetchedTracks.stream().toList().toString());
    return new ResponseEntity<>(finalResponse, HttpStatus.OK);

    }
}
