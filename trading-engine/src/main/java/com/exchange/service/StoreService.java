package com.exchange.service;

import com.exchange.database.DataBaseTemplate;
import com.exchange.entity.trade.EventEntity;
import com.exchange.message.event.AbstractEvent;
import com.exchange.messaging.MessageTypes;
import com.exchange.support.EntitySupport;
import com.exchange.support.LoggerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class StoreService extends LoggerSupport {
    
    @Autowired
    MessageTypes messageTypes;
    
    @Autowired
    DataBaseTemplate dataBaseTemplate;
    
    public List<AbstractEvent> loadEventFromDb(long lastEventId) {
        List<EventEntity> events = this.dataBaseTemplate.from(EventEntity.class)
                .where("sequenceId > ?", lastEventId)
                .orderBy("sequenceId")
                .limit(100000).list();
        return events.stream().map(event -> (AbstractEvent) messageTypes.deserialize(event.data))
                .collect(Collectors.toList());
    }
    
    public void insertIgnore(List<? extends EntitySupport> list) {
        dataBaseTemplate.insertIgnore(list);
    }
}
