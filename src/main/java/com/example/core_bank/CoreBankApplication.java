package com.example.core_bank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication


public class CoreBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreBankApplication.class, args);
    }

}
