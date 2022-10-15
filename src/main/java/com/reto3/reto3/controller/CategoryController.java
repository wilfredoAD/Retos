package com.reto3.reto3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto3.reto3.model.Category;
import com.reto3.reto3.service.CategoryService;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST,
        RequestMethod.PUT })

public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> gCategoriesFull() {
        return categoryService.getCategoryFull();
    }

    @GetMapping("/{Id}")
    public Optional<Category> getCategoryId(@PathVariable("id") int idCategory) {
        return categoryService.getCategoryId(idCategory);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }
}
