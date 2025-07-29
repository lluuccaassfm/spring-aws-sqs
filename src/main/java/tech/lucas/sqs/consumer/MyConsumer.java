package tech.lucas.sqs.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    Logger log = LoggerFactory.getLogger(MyConsumer.class);

    @SqsListener("minha-fila")
    public void listen(Object messageQueue) throws JsonProcessingException {
        log.info("Start consumer");
        var objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(messageQueue);
        Message message = objectMapper.readValue(json, Message.class);
        log.info("Message received: " + message.content());
    }

}
