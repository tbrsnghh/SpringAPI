package com.example.swaggerconfig.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentImageDTO {
    @JsonProperty("student_id")
    @Min(value = 1, message = "Id phải lớn 0")
    private long studentId;
    @Size(min = 5, max = 200, message = "Tên hình ảnh từ 5 ký tự và nhỏ hơn 200")
    @JsonProperty("image_url")
    private String imageUrl;
}
