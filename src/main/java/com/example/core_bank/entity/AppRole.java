package com.example.core_bank.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "APP_ROLE")
public class AppRole {
    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID", nullable = false)
    private Long roleId;
    @Column(name = "ROLE_NAME", length = 30, nullable = false)
    private String roleName;

}
