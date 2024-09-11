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
    private String ten;
    private String thanhpho;
    private LocalDate ngsinh;
    private String xepLoai;
    public static StudentResponse from(Student student) {
        StudentResponse studentResponse = StudentResponse.builder()
                .id(student.getId())
                .ten(student.getTen())
                .thanhpho(student.getThanhpho())
                .ngsinh(student.getNgsinh())
                .xepLoai(String.valueOf(student.getXepLoai()))
                .build();
        studentResponse.setCreateAt(student.getCreatedAt());
        studentResponse.setUpdatedAt(student.getUpdatedAt());
        return studentResponse;
    }
}
