package com.exchange.bean;

import com.exchange.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;

public class OrderBookBean {
    
    public static final String EMPTY = JsonUtil.writeJson(new OrderBookBean(0, BigDecimal.ZERO, List.of(), List.of()));
    
    @JsonIgnore
    public long sequenceId;
    
    public BigDecimal price;
    
    public List<OrderBookItemBean> buy;
    
    public List<OrderBookItemBean> sell;
    
    public OrderBookBean(long sequenceId, BigDecimal price, List<OrderBookItemBean> buy, List<OrderBookItemBean> sell) {
        this.sequenceId = sequenceId;
        this.price = price;
        this.buy = buy;
        this.sell = sell;
    }
}
