package com.example.demoD060924.services;

import com.example.demoD060924.dtos.CategoryDTO;
import com.example.demoD060924.models.Category;
import com.example.demoD060924.reponses.CategoryResponse;
import com.example.demoD060924.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    public final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(CategoryDTO category) {
        Category category1 = Category.builder().name(category.getCategoryName()).build();
        return categoryRepository.save(category1);
    }

    @Override
    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(long id, CategoryDTO category) {
        Category oldCategory = categoryRepository.findById(id).get();
        oldCategory.setName(category.getCategoryName());
        return categoryRepository.save(oldCategory);
    }

    @Override
    public Page<CategoryResponse> getAllCategories(PageRequest pageRequest) {
        return categoryRepository.findAll(pageRequest).map(CategoryResponse::fromCategory);
    }
}
