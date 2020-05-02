package com.digitfaber.messaging.example.spring;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final ExamplePublisherService examplePublisherService;

    @GetMapping(value = "/synchronous")
    String synchronous() {
        log.info("Synchronous endpoint: called.");
        Integer tasksCount = 1;
        Integer taskExecutionTimeInMs = 10000;
        examplePublisherService.synchronous(tasksCount, taskExecutionTimeInMs);
        log.info("Synchronous endpoint: returning response.");
        return "Done.";
    }

    @GetMapping(value = "/synchronous/{tasksCount}/{taskExecutionTimeInMs}")
    String parametrizedSynchronous(@PathVariable Integer tasksCount, @PathVariable Integer taskExecutionTimeInMs) {
        log.info("Synchronous endpoint: called.");
        examplePublisherService.synchronous(tasksCount, taskExecutionTimeInMs);
        log.info("Synchronous endpoint: returning response.");
        return "Done.";
    }

    @GetMapping(value = "/asynchronous")
    String asynchronous() {
        log.info("Asynchronous endpoint: called.");
        Integer tasksCount = 1;
        Integer taskExecutionTimeInMs = 10000;
        examplePublisherService.asynchronous(tasksCount, taskExecutionTimeInMs);
        log.info("Asynchronous endpoint: returning response.");
        return "Done.";
    }

    @GetMapping(value = "/asynchronous/{tasksCount}/{taskExecutionTimeInMs}")
    String parametrizedAsynchronous(@PathVariable Integer tasksCount, @PathVariable Integer taskExecutionTimeInMs) {
        log.info("Asynchronous endpoint: called.");
        examplePublisherService.asynchronous(tasksCount, taskExecutionTimeInMs);
        log.info("Asynchronous endpoint: returning response.");
        return "Done.";
    }

}
