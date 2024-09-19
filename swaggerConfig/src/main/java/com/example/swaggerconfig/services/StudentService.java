package com.example.swaggerconfig.services;

import com.example.swaggerconfig.dtos.StudentDTO;
import com.example.swaggerconfig.dtos.StudentImageDTO;
import com.example.swaggerconfig.models.Student;
import com.example.swaggerconfig.models.StudentImage;
import com.example.swaggerconfig.models.XepLoai;
import com.example.swaggerconfig.repositories.StudentImageRepository;
import com.example.swaggerconfig.repositories.StudentRepository;
import com.example.swaggerconfig.responses.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;
    private final StudentImageRepository studentImageRepository;

    @Override
    public Page<Student> getAllStudentsPageable(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student saveStudent(StudentDTO studentDTO) {
        Student student = Student.builder()
                .ten(studentDTO.getTen())
                .thanhpho(studentDTO.getThanhpho())
                .ngsinh(studentDTO.getNgsinh())
                .xepLoai(XepLoai.fromTen(String.valueOf(studentDTO.getXepLoai()))) // Chuyển đổi từ String sang Enum
                .build();
        return studentRepository.save(student);
    }
    public List<Student> saveStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, StudentDTO student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setTen(student.getTen());
        existingStudent.setThanhpho(student.getThanhpho());
        existingStudent.setNgsinh(student.getNgsinh());
        existingStudent.setXepLoai(XepLoai.fromTen(String.valueOf(student.getXepLoai())));
        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findByTenContainingIgnoreCase(String name) {
        return studentRepository.findByTenContainingIgnoreCase(name);
    }
    @Override
    public StudentImage saveStudentImage(long studentId, StudentImageDTO studentImageDTO) {
        Student student = getStudentById(studentId);
        StudentImage studentImage = StudentImage.builder()
                .student(student)
                .imageUrl(studentImageDTO.getImageUrl())
                .build();
        return studentImageRepository.save(studentImage);
    }
    @Override
    public List<StudentImage> getAllStudentImages(Long studentId) {
        return studentImageRepository.findByStudentId(studentId);
    }

    @Override
    public StudentImage getStudentImageById(Long studentImageId) {
        return studentImageRepository.findById(studentImageId).orElse(null);
    }

    @Override
    public void deleteStudentImageById(Long studentImageId) {
        studentImageRepository.deleteById(studentImageId);
    }

    @Override
    public List<Student> findByThanhPho(String name) {
        return studentRepository.findByThanhPho(name);
    }

    @Override
    public List<Student> findByThanhPhoVaTen(String name) {
        return studentRepository.findByThanhPhoVaTen(name);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
