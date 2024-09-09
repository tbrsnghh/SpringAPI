package com.example.swaggerconfig.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Tên khong được để trống")
    private String ten;

    @NotBlank(message = "Thanh pho khong dc de trong")
    private String thanhpho;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Bạn phải đẻ hồi xưa!")
    private LocalDate ngsinh;

    @NotNull(message = "Xếp loại không đc để trống")
    @Enumerated(EnumType.STRING)
    private XepLoai xepLoai;
}
