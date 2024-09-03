//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kafka.Kafka.Service.Consumer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private String consumedLastMessage;
    private final List<String> consumedMessages = new ArrayList();


    @KafkaListener(
            topics = {"second_topic"},
            groupId = "group_id1"
    )
    public void consume(String message) {
        this.consumedLastMessage = message;
        this.consumedMessages.add(message);
        System.out.println("lastmessage " + this.consumedLastMessage);
    }

    public String consumelastMessage() {
        return this.consumedLastMessage;
    }

    public List<String> consumeAll() {
        return new ArrayList(this.consumedMessages);
    }
}
