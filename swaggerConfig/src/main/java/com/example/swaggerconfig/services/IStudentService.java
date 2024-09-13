package com.example.swaggerconfig.services;

import com.example.swaggerconfig.dtos.StudentDTO;
import com.example.swaggerconfig.dtos.StudentImageDTO;
import com.example.swaggerconfig.models.Student;
import com.example.swaggerconfig.models.StudentImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    public List<Student> getAllStudents();
    public Page<Student> getAllStudentsPageable(Pageable pageable);
    public List<Student> saveStudents(List<Student> students);
    public Student getStudentById(Long id);
    public Student updateStudent(Long id, StudentDTO student);
    public void deleteStudentById(Long id);
    public Student saveStudent(StudentDTO studentDTO);
    List<Student> findByTenContainingIgnoreCase(String ten);
    List<Student> findByThanhPho(String name);
    List<Student> findByThanhPhoVaTen(String name);
    StudentImage saveStudentImage(long studentId, StudentImageDTO studentImageDTO);
    List<StudentImage> getAllStudentImages(Long studentId);
}
