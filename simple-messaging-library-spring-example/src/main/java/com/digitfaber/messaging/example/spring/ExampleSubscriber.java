package com.digitfaber.messaging.example.spring;

import com.digitfaber.messaging.MessageListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExampleSubscriber {

    public static final String EXAMPLE_EXCHANGE_NAME = "example.exchange";
    public static final String EXAMPLE_EVENT_NAME = "ExampleEvent";

    @SneakyThrows
    @MessageListener(exchange = EXAMPLE_EXCHANGE_NAME, message = EXAMPLE_EVENT_NAME)
    private void subscribe(Message message) {
        String publishingMethod = message.getPublishingMethod();
        log.info(publishingMethod + " subscriber: received message.");
        log.info(publishingMethod + " subscriber: processing started.");
        Thread.sleep(message.getProcessingTimeInMs());
        log.info(publishingMethod + " subscriber: processing finished.");
    }

}
