package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.reto3.model.Category;
import com.reto3.reto3.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategoryFull() {
        return categoryRepository.getCategoryFull();
    }

    public Optional<Category> getCategoryId(int idCategory) {
        return categoryRepository.getCategoryId(idCategory);
    }

    public Category saveCategory(Category category) {
        if (category.getId() == null) {
            return categoryRepository.saveCategory(category);
        } else {
            Optional<Category> categoryAux = categoryRepository.getCategoryId(category.getId());
            if (categoryAux.isEmpty()) {
                return categoryRepository.saveCategory(category);
            } else {
                return category;
            }
        }
    }

}
