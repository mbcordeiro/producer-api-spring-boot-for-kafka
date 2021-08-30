package com.matheuscordeiro.kafkaproducer.producerapi.producers;

import com.matheuscordeiro.kafkaproducer.producerapi.dto.CarDTO;

public interface CarProducer {
    public void send(CarDTO carDTO);
}
