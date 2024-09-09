package com.example.swaggerconfig.repositories;

import com.example.swaggerconfig.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
