package com.kafka.student.controller.Consumer;

import com.kafka.student.service.consumer.ConsumerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.Collections;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;


@WebMvcTest(ConsumerEndPoints.class)
public class ConsumerEndPointTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsumerService consumerService;

    @BeforeEach
    public void setUp() {
        Mockito.reset(consumerService);
    }

    @Test
    public void testConsumeAll_EmptyList() throws Exception {

        when(consumerService.consumeAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/kafka/consumeAll"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

    }

    @Test
    public void testConsumeAll_NonEmptyList() throws Exception {
        when(consumerService.consumeAll()).thenReturn(Arrays.asList("message1", "message2"));
        mockMvc.perform(get("/api/kafka/consumeAll"))
                .andExpect(status().isOk())
                .andExpect(content().json("[\"message1\", \"message2\"]"));
    }

    @Test
    public void testConsumeLastMessage_withMessage() throws Exception {
        when(consumerService.consumelastMessage()).thenReturn("message");
        mockMvc.perform(get("/api/kafka/consumeLastMessage"))
                .andExpect(status().isOk())
                .andExpect(content().string("last consumed message: message"));
    }

    @Test
    public void testConsumeLastMessage_NoMessage() throws Exception {
        when(consumerService.consumelastMessage()).thenReturn(null);
        mockMvc.perform(get("/api/kafka/consumeLastMessage"))
                .andExpect(status().isOk())
                .andExpect(content().string("no Consumed Messages"));
    }


}
