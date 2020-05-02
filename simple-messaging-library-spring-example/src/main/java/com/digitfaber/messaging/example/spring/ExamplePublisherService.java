package com.digitfaber.messaging.example.spring;

import com.digitfaber.messaging.MessagePublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

import static com.digitfaber.messaging.example.spring.ExampleSubscriber.EXAMPLE_EVENT_NAME;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExamplePublisherService {

    private final MessagePublisher messagePublisher;

    public void synchronous(Integer tasksCount, Integer taskExecutionTimeInMs) {
        log.info("Synchronous service: called.");
        String publishingMethod = "Synchronous";
        Message message = Message.of(publishingMethod, taskExecutionTimeInMs);
        IntStream.range(0, tasksCount)
                .forEach(i -> messagePublisher.publishSynchronously(EXAMPLE_EVENT_NAME, message));
        log.info("Synchronous service: finished.");
    }

    public void asynchronous(Integer tasksCount, Integer taskExecutionTimeInMs) {
        log.info("Asynchronous service: called.");
        String publishingMethod = "Asynchronous";
        Message message = Message.of(publishingMethod, taskExecutionTimeInMs);
        IntStream.range(0, tasksCount)
                .forEach(i -> messagePublisher.publish(EXAMPLE_EVENT_NAME, message));
        log.info("Asynchronous service: finished.");
    }

}
