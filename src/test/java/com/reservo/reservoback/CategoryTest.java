package com.reservo.reservoback;

import com.reservo.reservoback.controller.CategoryController;
import com.reservo.reservoback.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ReservoBackApplication.class)
@Transactional
public class CategoryTest {

    @Autowired
    private CategoryController categoryController;

    private Integer idCategory;

    @BeforeEach
    public void setUp() throws Exception {
        Category category = new Category("Massage test 1");
        //save user, verify has ID value after save
        assertNull(category.getId());//null before save
        this.categoryController.saveCategory(category);
        idCategory = category.getId();
        assertNotNull(idCategory);
    }

    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        Optional<Category> categoryOptional = categoryController.getCategory(idCategory);
        assertNotNull(categoryOptional);
        Category category = categoryOptional.get();
        assertEquals("Massage test 1", category.getName());
    }
}
