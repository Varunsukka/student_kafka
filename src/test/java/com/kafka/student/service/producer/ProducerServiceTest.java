package com.kafka.student.service.producer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.verify;

public class ProducerServiceTest {
    @Mock
    private KafkaTemplate<String,String> kafkaTemplate;

    @InjectMocks
    private ProducerService producerService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testSendMessage(){
        String message="Test Message";

        producerService.sendMessage(message);

        verify(kafkaTemplate).send(ProducerService.TOPIC,message);
    }
    @Test
    public void testSendEmptyMessage(){
        String message="";

        producerService.sendMessage(message);

        verify(kafkaTemplate).send(ProducerService.TOPIC,message);
    }
    @Test
    public void testSendNullMessage(){
        String message=null;

        producerService.sendMessage(message);

        verify(kafkaTemplate).send(ProducerService.TOPIC,message);
    }

}
