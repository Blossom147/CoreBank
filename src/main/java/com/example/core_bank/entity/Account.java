package com.example.core_bank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "APP_ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",unique = true,nullable = false)
    private Long id;

    @Column(name = "AMOUNT",nullable = false)
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private AppUser appUser;
}
