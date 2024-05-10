package org.training.microservice.msorder.integration.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationIntegration {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String messsage,
                       String dest) {
        Message messageLoc = new Message(dest,
                                         messsage);
        rabbitTemplate.convertAndSend("message-topic-exchange",
                                      "sms.europe.turkey.istanbul.delivery",
                                      messageLoc);


    }

}
