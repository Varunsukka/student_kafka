package com.kafka.Kafka.Service.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;



public class ConsumerServiceTest {
    @InjectMocks
    private ConsumerService consumerService;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testConsume(){
        String message ="Hello Kafka";

        consumerService.consume(message);

        assertEquals("Hello Kafka", consumerService.consumelastMessage());

        List<String> allMessages= consumerService.consumeAll();
        assertEquals(1,allMessages.size());
        assertTrue(allMessages.contains("Hello Kafka"));
    }

    @Test
    public void testConsumeAll(){
        String message1="Message1";
        String message2="Message2";

        consumerService.consume(message1);
        consumerService.consume(message2);

        List<String> allMessages =consumerService.consumeAll();
        assertEquals(2,allMessages.size());
        assertTrue(allMessages.contains("Message1"));
        assertTrue(allMessages.contains("Message2"));
    }

    @Test
    public void testConsumeLastMessage(){
        String message1="Message1";
        String message2="Message2";

        consumerService.consume(message1);
        consumerService.consume(message2);

        List<String> allMessages =consumerService.consumeAll();
        assertEquals("Message2",consumerService.consumelastMessage());
    }
    @Test
    public void testConsumeAllWithNomessages(){
        List<String> allMessages =consumerService.consumeAll();
        assertTrue(allMessages.isEmpty());
    }


}
