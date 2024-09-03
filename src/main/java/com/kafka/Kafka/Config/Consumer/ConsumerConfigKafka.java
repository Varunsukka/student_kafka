
package com.kafka.Kafka.Config.Consumer;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class ConsumerConfigKafka {
    public ConsumerConfigKafka() {
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> configProps = new HashMap();
        configProps.put("bootstrap.servers", "localhost:9092");
        configProps.put("group.id", "group_id");
        configProps.put("key.deserializer", StringDeserializer.class.getName());
        configProps.put("value.deserializer", JsonDeserializer.class.getName());
        configProps.put("spring.json.trusted.packages", "*");
        return new DefaultKafkaConsumerFactory(configProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(this.consumerFactory());
        return factory;
    }
}
