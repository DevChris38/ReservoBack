package com.reservo.reservoback;

import com.reservo.reservoback.controller.CategoryController;
import com.reservo.reservoback.controller.ProfessionalController;
import com.reservo.reservoback.controller.ServiceController;
import com.reservo.reservoback.model.Services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ReservoBackApplication.class)
@Transactional
public class ServiceTest {

    @Autowired
    private ServiceController serviceController;

    @Autowired
    private ProfessionalController professionalController;

    @Autowired
    private CategoryController categoryController;

    private Integer idService;

    @BeforeEach
    public void setUp() throws Exception {
        Services service = new Services("massage thai", 60, 70.0, categoryController.getCategory(1).orElseThrow(() -> new RuntimeException("Category not found")), professionalController.getProfessional(1).orElseThrow(() -> new RuntimeException("Professional not found")));
        //save service, verify has ID value after save
        assertNull(service.getId());//null before save
        this.serviceController.saveService(service);
        idService = service.getId();
        assertNotNull(idService);
    }

    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        Optional<Services> serviceOptional = serviceController.getService(idService);
        assertNotNull(serviceOptional);
        Services service = serviceOptional.get();
        assertEquals("massage thai", service.getName());
    }

}
