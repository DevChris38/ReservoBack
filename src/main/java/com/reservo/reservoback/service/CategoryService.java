package com.reservo.reservoback.service;

import com.reservo.reservoback.model.Category;
import com.reservo.reservoback.repository.CategoryRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> getCategory(final Integer id) {
        return categoryRepository.findById(id);
    }

    public void deleteCategory(final Integer id) {
        categoryRepository.deleteById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
