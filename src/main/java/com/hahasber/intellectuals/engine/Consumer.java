package com.hahasber.intellectuals.engine;

import static com.hahasber.intellectuals.constant.Topic.OUTPUT_DATA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value = "intellectuals.kafka.consumer-enabled", havingValue = "true")
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(com.hahasber.intellectuals.engine.Producer.class);

    @KafkaListener(topics = {
            OUTPUT_DATA,
    })
    public void consume(
            final @Payload String message,
            final @Header(KafkaHeaders.OFFSET) Integer offset,
            final @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
            final @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            final @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            final @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
            final Acknowledgment acknowledgment
    ) {

        logger.info(String.format("#### -> Consumed message -> %s", message));
        acknowledgment.acknowledge();
    }
}

