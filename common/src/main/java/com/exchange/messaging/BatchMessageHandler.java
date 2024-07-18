package com.exchange.messaging;

import com.exchange.message.AbstractMessage;

import java.util.List;

@FunctionalInterface
public interface BatchMessageHandler<T extends AbstractMessage> {
    
    void processMessages(List<T> messages);
}