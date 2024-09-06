package com.example.demoD060924.services;

import com.example.demoD060924.dtos.CategoryDTO;
import com.example.demoD060924.models.Category;
import com.example.demoD060924.reponses.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
public interface ICategoryService {
    Category getCategoryById(long id);
    List<Category> getAllCategories();
    Category saveCategory(CategoryDTO category);
    void deleteCategoryById(long id);
    Category updateCategory(long id, CategoryDTO category);
    Page<CategoryResponse> getAllCategories(PageRequest pageRequest);
}
