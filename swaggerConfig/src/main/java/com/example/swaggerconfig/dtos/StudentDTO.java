package com.example.swaggerconfig.dtos;

import com.example.swaggerconfig.models.XepLoai;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    @NotBlank(message = "Tên không được để trống")
    private String ten;

    @NotBlank(message = "Thành phố không được để trống")
    private String thanhpho;

    @NotNull(message = "Ngày sinh không được để trống")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Bạn phải đẻ hồi xưa!")
    private LocalDate ngsinh;



    private XepLoai xepLoai; // Bạn có thể thay đổi thành kiểu Enum nếu cần
}
