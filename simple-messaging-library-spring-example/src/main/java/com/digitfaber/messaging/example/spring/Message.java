package com.digitfaber.messaging.example.spring;

import lombok.Value;

@Value(staticConstructor = "of")
public class Message {

    String publishingMethod;
    Integer processingTimeInMs;

}