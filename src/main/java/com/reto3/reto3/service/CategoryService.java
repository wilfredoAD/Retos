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

    public Category updateFull(Category category) {
        if (validateFields(category)) {
            if (category.getId() != null) {
                Optional<Category> categoryFind = getCategoryId(category.getId());
                if (!categoryFind.isEmpty()) {
                    if (category.getDescription() != null) {
                        categoryFind.get().setDescription(category.getDescription());
                    }
                    if (category.getName() != null) {
                        categoryFind.get().setName(category.getName());
                    }
                    return categoryRepository.saveCategory(categoryFind.get());
                }
            }
            return category;
        }
        return category;
    }

    public boolean deleteCategory(int id) {
        Boolean result = getCategoryId(id).map(element -> {
            categoryRepository.delete(element);
            return true;
        }).orElse(false);
        return result;
    }

    public boolean validateFields(Category category) {
        return (category.getName().length() <= 45 && category.getDescription().length() <= 250);
    }

}
