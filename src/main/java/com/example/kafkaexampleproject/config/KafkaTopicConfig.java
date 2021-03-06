package com.example.kafkaexampleproject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic kafkaStringTopicBuilder(){
        return TopicBuilder.name("tryingout")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic kafkaUserTopicBuilder(){
        return TopicBuilder.name("tryingoutuser")
                .partitions(1)
                .replicas(1)
                .build();
    }

}
