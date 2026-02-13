package com.audius.music.streaming.kafka.interfaces;


public interface Consumer {
    public void processMessage(String content);

}
