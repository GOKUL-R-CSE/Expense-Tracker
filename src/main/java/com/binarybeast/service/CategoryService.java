package com.binarybeast.service;

import java.util.List;
import java.util.Optional;

import com.binarybeast.entity.Category;

public interface CategoryService {

    List<Category> getCategories();

    Optional<Category> getCategory(Long id);

    Category addcategory(Category category);

    void deleteCategory(long id);

    Category updateCategory(long id, Category category);

}
