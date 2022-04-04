package com.example.kafkaexampleproject.service;

import com.example.kafkaexampleproject.constants.ConstantValues;
import com.example.kafkaexampleproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateString;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplateUser;


    public void sendMessage(String message) {
        this.kafkaTemplateString.send(ConstantValues.topicNameString, message);
    }

    public void sendUserMessage(User userData){
        this.kafkaTemplateUser.send(ConstantValues.topicNameUser, userData);
    }
}
