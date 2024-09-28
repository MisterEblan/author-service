package com.mreblan.authorservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KafkaConsumerService {
    @KafkaListener(topics = "post-created-topic", groupId = "my-post-created")
    public void receivedMessage(@Payload String authorId) {
      log.info(authorId);
    }
}
