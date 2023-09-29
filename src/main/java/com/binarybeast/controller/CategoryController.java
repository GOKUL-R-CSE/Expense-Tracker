package com.binarybeast.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.binarybeast.entity.Category;
import com.binarybeast.service.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategories")
    public ResponseEntity<List<Category>> getCategories(){
        return new ResponseEntity<List<Category>>(categoryService.getCategories(), HttpStatus.FOUND);
    }

    @GetMapping("/getCategory/{id}")
    public Optional<Category> getCategory(
            @PathVariable(name = "id") Long id
    ){
        return categoryService.getCategory(id);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(
            @Validated
            @RequestBody Category category
    ){
        return new ResponseEntity<Category>(categoryService.addcategory(category), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(
            @PathVariable(name = "id") long id
    ) {
        categoryService.deleteCategory(id);
        return "Category deleted successfully";
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable(name = "id") long id,
            @RequestBody Category category
    ) {
        return new ResponseEntity<Category>(categoryService.updateCategory(id, category), HttpStatus.ACCEPTED);
    }

}
