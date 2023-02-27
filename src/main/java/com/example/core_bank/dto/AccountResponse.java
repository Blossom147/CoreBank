package com.example.core_bank.dto;

import lombok.Data;

@Data
public class AccountResponse {
    private Long idAccount;
    private Long amount;
    private String userName;
}
