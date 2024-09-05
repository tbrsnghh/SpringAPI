package com.example.springapiuser.departments;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, String> {
    List<Department> findByUsersContains(String userId);
}
