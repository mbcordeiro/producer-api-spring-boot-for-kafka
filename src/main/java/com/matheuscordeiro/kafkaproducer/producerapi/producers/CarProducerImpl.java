package com.matheuscordeiro.kafkaproducer.producerapi.producers;

import com.matheuscordeiro.kafkaproducer.producerapi.dto.CarDTO;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarProducerImpl implements CarProducer{
    private static final Logger logger = LoggerFactory.getLogger(CarProducerImpl.class);
    private final String topic;
    private final KafkaTemplate<String, CarDTO> kafkaTemplate;

    public CarProducerImpl(@Value("${topic.name}") String topic, KafkaTemplate<String, CarDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(CarDTO carDTO) {
        kafkaTemplate.send(topic, carDTO).addCallback(
                success -> logger.info("Messagem send " + success.getProducerRecord().value()),
                failure -> logger.info("Message failure " + failure.getMessage())
        );
    }
}
