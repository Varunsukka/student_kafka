//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kafka.student.controller.Producer;

import com.kafka.student.service.producer.ProducerService;
import com.kafka.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/kafka"})
public class ProducerEndPoints {
    @Autowired
    private ProducerService producerService;
    @PostMapping({"/publish"})
    public String PublishMessage(@RequestBody Student student) {
        producerService.sendMessage(student);
        return "Message published successfully";
    }
}
