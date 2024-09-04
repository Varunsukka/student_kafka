//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kafka.Kafka.Controller.Producer;

import com.kafka.Kafka.Service.Producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/kafka"})
public class ProducerEndPoints {
    @Autowired
    private ProducerService producerService;


    @PostMapping({"/publish"})
    public String PublishMessage(@RequestParam(value = "message", required = false) String message) {
        if (message==null || message.trim().isEmpty()) {
            return "Message cannot be null or empty";
        }
        this.producerService.sendMessage(message);
        return "Message published successfully";
    }
}
