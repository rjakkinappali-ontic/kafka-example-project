package com.example.kafkaexampleproject.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "tryingout", groupId = "groupId")
    void listener(String data){
        System.out.println("Recieved:  "+ data);
    }
}
