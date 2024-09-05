package com.example.demo_mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HomeRepository extends MongoRepository<Home, String> {
    List<Home> findByTitle(String title); // Phương thức tìm kiếm theo title
}
