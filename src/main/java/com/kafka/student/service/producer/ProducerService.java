//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kafka.student.service.producer;

import com.kafka.student.model.Student;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    public static final String TOPIC = "student";
    private final KafkaTemplate<String, Student> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, Student> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Student student) {
        this.kafkaTemplate.send(TOPIC, student);
    }

}
