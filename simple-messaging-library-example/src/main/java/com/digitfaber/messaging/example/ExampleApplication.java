package com.digitfaber.messaging.example;

import com.digitfaber.messaging.MessagePublisher;

import java.time.Duration;

public class ExampleApplication {

    public static void main(String[] args) throws Exception {
        MessagePublisher messagePublisher = MessagePublisher.builder()
                .exchangeName((ExampleSubscriber.EXAMPLE_EXCHANGE_NAME))
                .keepAliveTime(Duration.ofMillis(1)) //In order to not hold closing the application, I set this property to a very low value.
                .build();
        ExampleSubscriber exampleSubscriber = new ExampleSubscriber();
        messagePublisher.registerSubscriber(exampleSubscriber);

        System.out.println(" -- EXAMPLE 1 --");
        messagePublisher.publishSynchronously(ExampleSubscriber.EXAMPLE_MESSAGE_NAME, "| This synchronous message appears first.");
        System.out.println("| This one appears after.");
        System.out.println(" ---------------\n");

        System.out.println(" -- EXAMPLE 2 --");
        messagePublisher.publish(ExampleSubscriber.EXAMPLE_MESSAGE_NAME, "| This asynchronous message appears after, because the thread does not wait for this task to finish.");
        System.out.println("| This one appears first.");
        Thread.sleep(4000);
        System.out.println("| But it had to wait now, because this ASCII \"table\" need's to be nice and pretty.");
        System.out.println(" ---------------\n");

        messagePublisher.unregisterSubscriber(exampleSubscriber);

        System.out.println(" -- EXAMPLE 3 --");
        messagePublisher.publishSynchronously(ExampleSubscriber.EXAMPLE_MESSAGE_NAME, "This shouldn't appear at all, because the subscriber has been unregistered.");
        messagePublisher.publish(ExampleSubscriber.EXAMPLE_MESSAGE_NAME, "This shouldn't appear at all, because the subscriber has been unregistered.");
        System.out.println("| This appears. No fancy stuff here... Yep... Seriously, stop reading this and go back to coding ;)");
        System.out.println(" ---------------\n");
    }

}
