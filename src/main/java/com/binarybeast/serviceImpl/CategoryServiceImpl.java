package com.binarybeast.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarybeast.entity.Category;
//import com.binarybeast.exception.ResourceAlreadyExistsException;
import com.binarybeast.exception.ResourceNotFoundException;
import com.binarybeast.repository.CategoryRepository;
import com.binarybeast.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        Optional<Category> cat = categoryRepository.findById(id);
        if(cat.isEmpty()) {
            throw new ResourceNotFoundException("category", "specified id");
        }
        return cat;
    }

    @Override
    public Category addcategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(long id, Category category) {
        Category cat = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "specified id"));
        if(Objects.nonNull(category.getName()) && !"".equals(category.getName())){
            cat.setName(category.getName());
        }
        if(Objects.nonNull(category.getDescription()) && !"".equals(category.getDescription())){
            cat.setDescription(category.getDescription());
        }
        categoryRepository.save(cat);
        return cat;
    }

}
