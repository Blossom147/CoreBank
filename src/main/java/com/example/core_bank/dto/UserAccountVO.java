package com.example.core_bank.dto;

import com.example.core_bank.entity.AppUser;
import lombok.Data;

@Data
public class UserAccountVO {
    private Long id;
    private Long amount;
    private String userName;
    private Long userId;


}

