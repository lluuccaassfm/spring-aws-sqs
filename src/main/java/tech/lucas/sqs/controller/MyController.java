package tech.lucas.sqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.lucas.sqs.consumer.Message;
import tech.lucas.sqs.producer.MyProducer;

@RestController
@RequestMapping("/sqs")
public class MyController {

    @Autowired
    private MyProducer myProducer;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody Message messageDTO) {
        myProducer.sendMessageSqs(messageDTO);
    }
}
