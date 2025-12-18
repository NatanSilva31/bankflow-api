package com.example.bankflow.dtos;

import com.example.bankflow.domain.user.UserType;
import java.math.BigDecimal;

public class UserDTO {
    private String firstName;
    private String lastName;
    private String document;
    private BigDecimal balance;
    private String email;
    private String password;
    private UserType userType;
    private Long senderId;
    private Long receiverId;

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDocument() { return document; }
    public BigDecimal getBalance() { return balance; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public UserType getUserType() { return userType; }
    public Long getSenderId() { return senderId; }
    public Long getReceiverId() { return receiverId; }
}