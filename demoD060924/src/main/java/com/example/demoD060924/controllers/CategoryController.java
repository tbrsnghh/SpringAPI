package com.example.demoD060924.controllers;

import com.example.demoD060924.dtos.CategoryDTO;
import com.example.demoD060924.models.Category;
import com.example.demoD060924.reponses.CategoryListResponse;
import com.example.demoD060924.reponses.CategoryResponse;
import com.example.demoD060924.services.CategoryService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> index() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        categoryService.deleteCategoryById(id);
        return "Deleted";
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable long id, @RequestBody CategoryDTO category) {
        return categoryService.updateCategory(id, category);
    }
    @PostMapping
    public Category create(@RequestBody CategoryDTO category) {
        return categoryService.saveCategory(category);
    }
    @PostMapping("insert0")
    public ResponseEntity<?> insert0(@Valid @RequestBody CategoryDTO category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage).toList();
            return ResponseEntity.badRequest().body(errors);
        }
        categoryService.saveCategory(category);
        return ResponseEntity.ok("inserted" + category);
    }

    @PostMapping("/insert")
    public String insert(@Valid @RequestBody CategoryDTO category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getField() + ": " + error.getDefaultMessage());
            }
            return errors.toString();
        }
        categoryService.saveCategory(category);
        return "Inserted" + category.toString();
    }
    @GetMapping("/list")
    public ResponseEntity<CategoryListResponse> getAllCategories(@RequestParam("page") int page
                                                , @RequestParam("limit") int limit) {
        PageRequest pageRequest = PageRequest.of(
                page, limit);
        Page<CategoryResponse> categoryResponsePage = categoryService.getAllCategories(pageRequest);
        int totalPages = categoryResponsePage.getTotalPages();
        List<CategoryResponse> categoryResponses = categoryResponsePage.getContent();
        return ResponseEntity.ok(CategoryListResponse.builder()
                .categories(categoryResponses)
                .totalPages(totalPages)
                .build());
    }
}
