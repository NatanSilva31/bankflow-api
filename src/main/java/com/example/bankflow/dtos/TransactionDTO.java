package com.example.bankflow.dtos;

import java.math.BigDecimal;

public class TransactionDTO {
    private BigDecimal value;
    private Long senderId;
    private Long receiverId;

    // Getters
    public BigDecimal getValue() { return value; }
    public Long getSenderId() { return senderId; }
    public Long getReceiverId() { return receiverId; }
}