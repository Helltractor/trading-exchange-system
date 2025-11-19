package com.helltractor.exchange.enums;

/**
 * User type enumeration.
 */
public enum UserType {
    
    /**
     * Internal debt user.
     */
    DEBT(1),
    
    /**
     * Internal trader user.
     */
    TRADER(0);
    
    final long userId;
    
    UserType(long userId) {
        this.userId = userId;
    }
    
    public long getInternalUserId() {
        return this.userId;
    }
}
