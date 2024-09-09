package com.example.swaggerconfig.controllers;

import com.example.swaggerconfig.dtos.StudentDTO;
import com.example.swaggerconfig.models.Student;
import com.example.swaggerconfig.repositories.StudentRepository;
import com.example.swaggerconfig.services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/student")
@RequiredArgsConstructor

public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody StudentDTO studentDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        Student savedStudent = studentService.saveStudent(studentDTO);
        return ResponseEntity.ok("Inserted: " + savedStudent);
    }
    @PostMapping("/batch")
    public List<Student> createStudents(@RequestBody List<Student> students) {
        return studentService.saveStudents(students);
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}
