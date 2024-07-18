package com.exchange.enums;

/**
 * User type enumeration.
 */
public enum UserType {
    
    DEBT(1),
    
    TRADER(0);
    
    /**
     * User id
     */
    final long userId;
    
    UserType(long userId) {
        this.userId = userId;
    }
    
    public long getInternalUserId() {
        return this.userId;
    }
}