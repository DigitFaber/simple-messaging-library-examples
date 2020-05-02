package com.digitfaber.messaging.example.spring;

import com.digitfaber.messaging.MessagePublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.digitfaber.messaging.example.spring.ExampleSubscriber.EXAMPLE_EXCHANGE_NAME;

@Configuration
public class ExampleConfiguration {

    @Bean
    public MessagePublisher messagePublisher() {
        return new MessagePublisher(EXAMPLE_EXCHANGE_NAME);
    }

}
