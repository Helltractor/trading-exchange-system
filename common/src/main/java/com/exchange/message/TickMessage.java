package com.exchange.message;

import com.exchange.entity.quatation.TickEntity;

import java.util.List;

public class TickMessage extends AbstractMessage {
    
    public long sequenceId;
    
    public List<TickEntity> ticks;
}
