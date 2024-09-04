package com.kafka.Kafka.Controller.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ConsumerEndPointTest {
    @InjectMocks
    private ConsumerEndPoints consumerEndPoints;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


}
