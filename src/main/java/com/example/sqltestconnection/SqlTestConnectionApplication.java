package com.example.sqltestconnection;

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
        String url = "jdbc:mysql://localhost:3306/testconnection1";
        String username = "root";
        String password = "root";

        // Подключиться к базе данных
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Успешное подключение к базе данных!");
            // Выполнить дополнительные операции с базой данных здесь
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных!");
            e.printStackTrace();
        }
    }

}
