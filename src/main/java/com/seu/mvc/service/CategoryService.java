package com.seu.mvc.service;

import com.seu.mvc.dto.CategoryRequest;
import com.seu.mvc.dto.CategoryResponse;
import com.seu.mvc.model.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findAllCat();

    CategoryResponse findCategoryById(Integer id);

    CategoryResponse findCategoryByName(String name);

    void createCategory(CategoryRequest categoryRequest);

    CategoryResponse editCategoryById(Integer id, CategoryRequest request);

    void deleteCategoryById(Integer id);
}
