package com.kafka.student.controller.Producer;

import com.kafka.student.service.producer.ProducerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProducerEndPoints.class)
public class ProducerEndpointsTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProducerService producerService;

    @BeforeEach
    public void setUp(){
        Mockito.reset(producerService);
    }
    @Test
    public void testPublishMessage() throws Exception{
        String message="message1";

        mockMvc.perform(post("/api/kafka/publish")
                        .param("message", message))
                .andExpect(status().isOk())
                .andExpect(content().string("Message published successfully"));
        verify(producerService).sendMessage(message);
    }

    @Test
    public void testPublishEmptyMessage() throws Exception{
        String message="";
        mockMvc.perform(post("/api/kafka/publish")
                        .param("message", message))
                .andExpect(status().isOk())
                .andExpect(content().string("Message cannot be null or empty"));


    }
    @Test
    public void testPublishNullMessage() throws Exception{
        String message=null;
        mockMvc.perform(post("/api/kafka/publish")
                        .param("message", message))
                .andExpect(status().isOk())
                .andExpect(content().string("Message cannot be null or empty"));


    }
}
