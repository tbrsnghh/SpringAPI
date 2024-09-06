package com.example.demoD060924.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDTO {
    @JsonProperty("name")
    @NotEmpty(message = "Tên không được rỗng nha")
    private String categoryName;
}
