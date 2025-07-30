package tech.lucas.sqs.producer;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyProducer {

    Logger log = LoggerFactory.getLogger(MyProducer.class);

    @Autowired
    private SqsTemplate sqsTemplate;

    public void sendMessageSqs(Object message) {
        var SQS = "https://localhost.localstack.cloud:4566/000000000000/fila-teste";
        log.info("Will Send message {} in queue {}", message, SQS);
        sqsTemplate.send(SQS, message);
        log.info("Message sent successfully!");
    }
}
