package tech.lucas.sqs.consumer;

import io.awspring.cloud.sqs.annotation.SnsNotificationMessage;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    Logger log = LoggerFactory.getLogger(MyConsumer.class);

    @SqsListener("fila-teste")
    public void listenNotificationSns(@SnsNotificationMessage Message messageQueue) {
        log.info("Start consumer");
        if(messageQueue.content() != null) {
            log.info("Message received: {}", messageQueue.content());
        } else {
            log.warn("Received null messageQueue");
        }
    }

    /*
    @SqsListener("fila-teste")
    public void listen(Message messageQueue) {
        log.info("Start consumer");
        if(messageQueue.content() != null) {
            log.info("Message received: {}", messageQueue.content());
        } else {
            log.warn("Received null messageQueue");
        }
    }*/
}
