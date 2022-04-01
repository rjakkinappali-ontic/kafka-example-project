package com.example.kafkaexampleproject.messagecontroller;

import com.example.kafkaexampleproject.model.MessageModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafkatesting")
public class MessageControllerClass {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageControllerClass(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public void publish(@RequestParam(value = "message") String message){
        kafkaTemplate.send("tryingout", message);
    }
}
