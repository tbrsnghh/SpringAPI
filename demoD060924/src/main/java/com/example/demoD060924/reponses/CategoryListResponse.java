package com.example.demoD060924.reponses;

import com.example.demoD060924.models.Category;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryListResponse {
    private List<CategoryResponse> categories;
    private int totalPages;
}
