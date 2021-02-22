package com.hahasber.intellectuals.engine;

import static com.hahasber.intellectuals.constant.KafkaIncomingMessageKey.IN_KEY;
import static com.hahasber.intellectuals.constant.Topic.OUTPUT_DATA;

import com.hahasber.intellectuals.constant.KafkaIncomingMessageKey;
import java.util.concurrent.ExecutionException;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Log4j2
@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public SendResult<String, String> sendMessage(String topic, KafkaIncomingMessageKey key,
            String message) throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<String, String>> send = this.kafkaTemplate
                .send(topic, key.getText(), message);
        return send.get();
    }


    public void sendMessage(String message, String reportDate) {
        try {
            MessageBuilder<String> stringMessageBuilder = MessageBuilder
                    .withPayload(message)
                    .setHeader(KafkaHeaders.TOPIC, OUTPUT_DATA)
                    .setHeader(KafkaHeaders.MESSAGE_KEY, IN_KEY.getText());

            RecordMetadata recordMetadata = kafkaTemplate.send(stringMessageBuilder.build()).get()
                    .getRecordMetadata();

            log.info(
                    String.format(
                            "Produced: topic: %s; offset: %d; partition: %d; value size: %d; date: %s",
                            recordMetadata.topic(),
                            recordMetadata.offset(),
                            recordMetadata.partition(),
                            recordMetadata.serializedValueSize(), reportDate));
        } catch (Exception e) {
            log.error(e);
        }

    }

}
