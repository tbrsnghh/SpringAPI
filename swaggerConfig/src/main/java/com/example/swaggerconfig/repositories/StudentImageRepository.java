package com.example.swaggerconfig.repositories;

import com.example.swaggerconfig.models.StudentImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentImageRepository extends JpaRepository<StudentImage, Long> {
    List<StudentImage> findByStudentId(Long studentId);
}
