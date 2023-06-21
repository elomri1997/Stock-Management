package com.example.emailservice.kafka;

import com.example.domains.dto.InvoiceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InvoiceEventConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceEventConsumer.class);

    @KafkaListener(
            topics="${spring.kafka.template.default-topic}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(InvoiceEvent event){
        LOGGER.info(String.format("Invoice event recieved in Email service => %s",event.toString()));



    }
}
