package com.example.kafkaexampleproject.service;

import com.example.kafkaexampleproject.constants.ConstantValues;
import com.example.kafkaexampleproject.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

    @KafkaListener(topics = ConstantValues.topicNameString, groupId = ConstantValues.groupId)
    public void listenerString(String data){
        System.out.println("Received:  "+ data);
    }

    @KafkaListener(topics = ConstantValues.topicNameUser, groupId = ConstantValues.groupId)
    public void listenerUser(String userData){
        System.out.println("Received: "+userData);
    }
}
