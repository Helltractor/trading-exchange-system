package com.helltractor.exchange.bean;

import java.math.BigDecimal;

import com.helltractor.exchange.enums.MatchType;

public record SimpleMatchDetailRecord(BigDecimal price, BigDecimal quantity, MatchType type) {

}
