package com.example.swaggerconfig.dtos;

import com.example.swaggerconfig.models.XepLoai;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 50, message = "Tên từ 2 đến 5 ký tự")
    private String ten;

    @NotBlank(message = "Thành phố không được để trống")
    private String thanhpho;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Ngày trong quá khứ!")
    private LocalDate ngsinh;

    @NotNull(message = "Xếp loại không đc để trống")
    private String xepLoai; // Bạn có thể thay đổi thành kiểu Enum nếu cần
}
