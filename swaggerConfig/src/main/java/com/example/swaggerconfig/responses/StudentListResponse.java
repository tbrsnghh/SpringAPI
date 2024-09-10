package com.example.swaggerconfig.responses;

import com.example.swaggerconfig.models.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentListResponse {
    List<StudentResponse> studentResponseList;
    private int totalPages;
}
