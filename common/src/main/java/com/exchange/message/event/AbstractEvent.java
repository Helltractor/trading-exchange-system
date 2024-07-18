package com.exchange.message.event;

import com.exchange.message.AbstractMessage;
import org.springframework.lang.Nullable;

public class AbstractEvent extends AbstractMessage {
    
    /**
     * Message id, set after sequenced.
     */
    public long sequenceId;
    
    /**
     * Previous message sequence id.
     */
    public long previousId;
    
    /**
     * Unique ID or null if not set.
     */
    @Nullable
    public String uniqueId;
}