package com.binarybeast.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarybeast.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    public Optional<Category> findByNameIgnoreCase(String name);

}
