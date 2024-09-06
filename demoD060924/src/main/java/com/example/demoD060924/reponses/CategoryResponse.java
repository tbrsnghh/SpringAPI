package com.example.demoD060924.reponses;

import com.example.demoD060924.models.Category;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse extends BaseResonse{
    private long id;
    private String name;
    public static CategoryResponse fromCategory(Category category){
        CategoryResponse categoryResponse = CategoryResponse.builder()
                .name(category.getName())
                .id(category.getId())
                .build();
        categoryResponse.setCreatedAt(category.getCreateAt());
        categoryResponse.setUpdatedAt(category.getUpdateAt());
        return categoryResponse;
    }
}
