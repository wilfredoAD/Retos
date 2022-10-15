package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Category;
import com.reto3.reto3.repository.crud.CategoryCrudRepositoryInterface;

@Repository
public class CategoryRepository {

    @Autowired
    public CategoryCrudRepositoryInterface categoryCrudRepositoryInterface;

    public List<Category> getCategoryFull() {
        return (List<Category>) categoryCrudRepositoryInterface.findAll();
    }

    public Optional<Category> getCategoryId(int idCategory) {
        return categoryCrudRepositoryInterface.findById(idCategory);
    }

    public Category saveCategory(Category category) {
        return categoryCrudRepositoryInterface.save(category);
    }
    public void delete(Category category){
        categoryCrudRepositoryInterface.delete(category);
    }

}
