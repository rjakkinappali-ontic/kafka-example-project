package com.example.kafkaexampleproject.messagecontroller;

import com.example.kafkaexampleproject.config.KafkaTopicConfig;
import com.example.kafkaexampleproject.model.User;
import com.example.kafkaexampleproject.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafkatesting")
public class MessageControllerClass {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private KafkaTopicConfig kafkaTopicConfig;

    @PostMapping("/publishString")
    public void publishString(@RequestParam(value = "message") String message, @RequestParam(value = "topicName") String topicName){
        kafkaProducerService.sendMessage(message);
    }

    @PostMapping("/publishUser")
    public void publishUser(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name, @RequestParam(value = "topicName") String topicName){
        User user = new User();
        user.setId(id);
        user.setFirstName(name);
        kafkaProducerService.sendUserMessage(user);
    }

}
