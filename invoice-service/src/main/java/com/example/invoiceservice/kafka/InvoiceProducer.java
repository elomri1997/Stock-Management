package com.example.invoiceservice.kafka;

import com.example.domains.dto.InvoiceEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(InvoiceProducer.class);

    private NewTopic topic;
    private KafkaTemplate<String, InvoiceEvent> kafkaTemplate;

    public InvoiceProducer (NewTopic topic, KafkaTemplate<String, InvoiceEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(InvoiceEvent event){
        LOGGER.info(String.format("Invoice Event => %s", event.toString()));
        //Create a Message
        Message<InvoiceEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        LOGGER.info(message.toString());
        kafkaTemplate.send(message);
    }
}
