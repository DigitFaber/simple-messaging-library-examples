package com.digitfaber.messaging.example;

import com.digitfaber.messaging.MessageListener;

public class ExampleSubscriber {

    public static final String EXAMPLE_EXCHANGE_NAME = "example.exchange";
    public static final String EXAMPLE_MESSAGE_NAME = "ExampleMessage";

    @MessageListener(exchange = EXAMPLE_EXCHANGE_NAME, message = EXAMPLE_MESSAGE_NAME)
    void subscribe(String message) throws Exception {
        Thread.sleep(3000);
        System.out.println(message);
    }

}
