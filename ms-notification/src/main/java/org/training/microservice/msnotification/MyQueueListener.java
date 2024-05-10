package org.training.microservice.msnotification;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyQueueListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "SMS-Queue", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "message-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
            key = "send-sms"
    )
    )
    public void listenSMS(String msg) {
        System.out.println("Gelen sms : " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "MAIL-Queue", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "message-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
            key = "send-mail"
    )
    )
    public void listenMAIL(String msg) {
        System.out.println("Gelen mail : " + msg);
    }
    // key = "sms.europe.turkey.istanbul.adv"
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "SMS-Topic-Queue", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "message-topic-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.TOPIC),
            key = "sms.#"
    )
    )
    public void listenTopicSMS(Message msg) {
        System.out.println("Gelen topic sms : " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "SMS-EUROPE-Queue", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "message-topic-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.TOPIC),
            key = "sms.europe.#"
    )
    )
    public void listenTopicEuropeSMS(Message msg) {
        System.out.println("Gelen Europe topic sms : " + msg);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "ALL-Topic-Queue", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "message-topic-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.TOPIC),
            key = "#"
    )
    )
    public void listenALLTopic(Message msg) {
        System.out.println("Gelen all message : " + msg);
    }

}
