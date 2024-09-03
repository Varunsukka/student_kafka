//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kafka.Kafka.Controller.Consumer;

import com.kafka.Kafka.Service.Consumer.ConsumerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/kafka"})
public class ConsumerEndPoints {
    @Autowired
    private ConsumerService consumerService;


    @GetMapping({"/consumeAll"})
    public List<String> consumeAll() {
        List<String> allMessages = this.consumerService.consumeAll();
        return allMessages;
    }

    @GetMapping({"/consumeLastMessage"})
    public String consumelastMessage() {
        String lastMessage = this.consumerService.consumelastMessage();
        return lastMessage != null ? "last consumed message: " + lastMessage : "no Consumed Messages";
    }
}
