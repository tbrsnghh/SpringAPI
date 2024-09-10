package com.example.swaggerconfig.responses;

import com.example.swaggerconfig.models.Student;
import com.example.swaggerconfig.models.XepLoai;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse extends DataResponse{
    private long id;
    private String name;
    private String city;
    private LocalDate dateOfBirth;
    private String xeploai;
    public static StudentResponse from(Student student) {
        StudentResponse studentResponse = StudentResponse.builder()
                .id(student.getId())
                .name(student.getTen())
                .city(student.getThanhpho())
                .dateOfBirth(student.getNgsinh())
                .xeploai(String.valueOf(student.getXepLoai()))
                .build();
        return studentResponse;
    }
}
