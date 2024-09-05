package com.example.DemoWithMongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DemoWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWithMongoDbApplication.class, args);
	}

}
