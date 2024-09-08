//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kafka.student.service.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kafka.student.model.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private String consumedLastMessage;
    private final List<Student> students = new ArrayList();


    @KafkaListener(
            topics = {"student"},
            groupId = "group"
    )
    public void consume(Student student) {
        System.out.println("lastmessage " + student);
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudentById(String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }
}
