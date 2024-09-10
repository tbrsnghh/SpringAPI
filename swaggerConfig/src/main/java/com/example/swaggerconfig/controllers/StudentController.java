package com.example.swaggerconfig.controllers;

import com.example.swaggerconfig.dtos.StudentDTO;
import com.example.swaggerconfig.exceptions.ResourceNotFoundException;
import com.example.swaggerconfig.models.Student;
import com.example.swaggerconfig.repositories.StudentRepository;
import com.example.swaggerconfig.responses.ApiResponse;
import com.example.swaggerconfig.responses.DataResponse;
import com.example.swaggerconfig.responses.StudentListResponse;
import com.example.swaggerconfig.responses.StudentResponse;
import com.example.swaggerconfig.services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/student")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllStudents() {
        ApiResponse apiResponse = ApiResponse.builder()
                .data(studentService.getAllStudents())
                .status(HttpStatus.OK.value())
                .message("Ok").build();
        return ResponseEntity.ok().body(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        ApiResponse apiResponse = ApiResponse.builder()
                .data(student)
                .status(HttpStatus.OK.value())
                .message("Student found").build();
        return ResponseEntity.ok(apiResponse);
    }

//    @GetMapping("/list")
//    public ResponseEntity<ApiResponse> getStudents(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size) {
//
//        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
//        Page<StudentResponse> studentResponses = studentService.getAllStudentsPageable(pageable);
//
//        int totalPages = studentResponses.getTotalPages();
//        List<Student> responses = studentResponses.getContent();
//
//        StudentListResponse studentListResponse = StudentListResponse.builder()
//                .studentResponseList(responses)
//                .totalPages(totalPages)
//                .build();
//
//        ApiResponse apiResponse = ApiResponse.builder()
//                .status(HttpStatus.OK.value())
//                .message("show students successfully")
//                .data(studentListResponse) // Đặt DataResponse vào data
//                .build();
//
//        return ResponseEntity.ok(apiResponse);
//    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody StudentDTO studentDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("Validation failed")
                    .data(errors)
                    .build();
            return ResponseEntity.badRequest().body(apiResponse);
        }
        Student savedStudent = studentService.saveStudent(studentDTO);
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Student created successfully")
                .data(savedStudent)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/batch")
    public ResponseEntity<ApiResponse> createStudents(@RequestBody List<Student> students) {
        List<Student> savedStudents = studentService.saveStudents(students);
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Students created successfully")
                .data(savedStudents)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage).toList();
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("Validation failed")
                    .data(errors)
                    .build();
            return ResponseEntity.badRequest().body(apiResponse);
        }
        Student student = studentService.getStudentById(id);
        if(student == null) {
            throw new ResourceNotFoundException("Student not found id:" + id);
        }
        Student updatedStudent = studentService.updateStudent(id, studentDTO);
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Student updated successfully")
                .data(updatedStudent)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if(student == null) {
            throw new ResourceNotFoundException("Student not found id:" + id);
        }
        studentService.deleteStudentById(id);
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Student deleted successfully")
                .data(null)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/search1")
    public ResponseEntity<ApiResponse> search1(@RequestParam String name) {
        List<Student> students = studentService.findByTenContainingIgnoreCase(name);
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Students found")
                .data(students)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/search2")
    public ResponseEntity<ApiResponse> search2(@RequestParam String name) {
        List<Student> students = studentService.findByThanhPho(name);
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Students found")
                .data(students)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/search3")
    public ResponseEntity<ApiResponse> search3(@RequestParam String name) {
        List<Student> students = studentService.findByThanhPhoVaTen(name);
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Students found")
                .data(students)
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
