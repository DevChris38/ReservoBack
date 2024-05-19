package com.reservo.reservoback.controller;

import com.reservo.reservoback.model.Category;
import com.reservo.reservoback.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Read - Get one category by id
     *
     * @return - A category
     */

    public Optional<Category> getCategory(final Integer id) {
        return categoryService.getCategory(id);
    }

    /**
     * Delete - Delete category
     */

    public void deleteCategory(final Integer id) {
        categoryService.deleteCategory(id);
    }

    /**
     * Create - Save customer
     *
     * @return - An object of Customer saved
     */

    public Category saveCategory(Category category) {
        return categoryService.saveCategory(category);
    }
}
