package com.example.swaggerconfig.repositories;

import com.example.swaggerconfig.models.Student;
import com.example.swaggerconfig.responses.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findAll(Pageable pageable);
    List<Student> findByTenContainingIgnoreCase(String ten);

    @Query("SELECT s FROM Student s WHERE s.thanhpho like LOWER(CONCAT('%',:name,'%'))")
    List<Student> findByThanhPho(String name);

    @Query("SELECT s FROM Student s WHERE s.thanhpho like LOWER(CONCAT('%',:name,'%')) OR s.ten like LOWER(CONCAT('%',:name,'%'))")
    List<Student> findByThanhPhoVaTen(String name);

    @Query("SELECT s FROM Student s WHERE year(s.ngsinh) BETWEEN :startYear and :endYear")
    List<Student> findByYearBetween(int startYear, int endYear);
}
