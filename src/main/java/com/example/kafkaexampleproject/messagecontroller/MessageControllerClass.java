package com.example.kafkaexampleproject.messagecontroller;

import com.example.kafkaexampleproject.model.User;
import com.example.kafkaexampleproject.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafkatesting")
public class MessageControllerClass {
    private KafkaProducerService kafkaProducerService;

    @Autowired
    public MessageControllerClass(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/publishString")
    public void publishString(@RequestParam(value = "message") String message){
        this.kafkaProducerService.sendMessage(message);
    }

    @PostMapping("/publishUser")
    public void publishUser(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name){
        User user = new User();
        user.setId(id);
        user.setFirstName(name);
        this.kafkaProducerService.sendUserMessage(user);
    }
}
