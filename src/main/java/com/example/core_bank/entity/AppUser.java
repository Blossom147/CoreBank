package com.example.core_bank.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "APP_USER")
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long userId;

    @Column(name = "USER_NAME", length = 36, nullable = false)
    private String userName;

    @Column(name = "ENCRYTED_PASSWORD", length = 128, nullable = true)
    private String encrytedPassword;

    @Column(name = "ENABLED", length = 1,nullable = true)
    private boolean enabled;

    @Column(name = "AGE",length = 10, nullable = false)
    private String age;

    @Column(name = "EMAIL", nullable = false,unique = true)
    private String email;

    @Column(name = "FULL_NAME",nullable = false)
    private String fullName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
    private Set<Account> listEmployee = new HashSet<>();

    public AppUser(){}


}
