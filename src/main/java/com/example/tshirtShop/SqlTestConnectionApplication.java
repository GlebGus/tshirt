package com.example.tshirtShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class SqlTestConnectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlTestConnectionApplication.class, args);
    }
}
