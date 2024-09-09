package com.example.swaggerconfig.services;

import com.example.swaggerconfig.dtos.StudentDTO;
import com.example.swaggerconfig.models.Student;
import com.example.swaggerconfig.models.XepLoai;
import com.example.swaggerconfig.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(StudentDTO studentDTO) {
        Student student = Student.builder()
                .ten(studentDTO.getTen())
                .thanhpho(studentDTO.getThanhpho())
                .ngsinh(studentDTO.getNgsinh())
                .xepLoai(studentDTO.getXepLoai()) // Chuyển đổi từ String sang Enum
                .build();
        return studentRepository.save(student);
    }

    public List<Student> saveStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setTen(student.getTen());
        existingStudent.setThanhpho(student.getThanhpho());
        existingStudent.setNgsinh(student.getNgsinh());
        existingStudent.setXepLoai(student.getXepLoai());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
