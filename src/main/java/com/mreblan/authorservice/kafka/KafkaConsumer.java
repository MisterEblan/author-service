package com.mreblan.authorservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer{

    @KafkaListener(topics = "course", groupId = "myConsumer")
    public void listen(String message) {
        log.info("Message received: " + message);
    }
}
