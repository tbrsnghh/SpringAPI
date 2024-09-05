package com.example.demo_mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DemoMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMongoDbApplication.class, args);
    }

}
