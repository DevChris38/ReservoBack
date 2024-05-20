package com.reservo.reservoback;

import com.reservo.reservoback.controller.CustomerServiceController;
import com.reservo.reservoback.controller.ServiceController;
import com.reservo.reservoback.model.Category;
import com.reservo.reservoback.model.CustomerServiceEntity;
import com.reservo.reservoback.model.key.CustomerServiceId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = ReservoBackApplication.class)
@Transactional
public class CustomerServiceTest {
    @Autowired
    private CustomerServiceController customerServiceController;

    @Autowired
    private ServiceController serviceController;

    private CustomerServiceId idCustomerService;

    @BeforeEach
    public void setUp() throws Exception {
        LocalDate now = LocalDate.now();
        LocalDate tomorrow = now.plusDays(1);

        CustomerServiceId id = new CustomerServiceId(1, now);
        CustomerServiceEntity customerServiceEntity = new CustomerServiceEntity(id, serviceController.getService(1).orElseThrow(() -> new RuntimeException("Category not found")), tomorrow);
        //save user, verify has ID value after save
        assertNull(customerServiceEntity.getId());//null before save
        this.customerServiceController.saveCustomerService(customerServiceEntity);
        idCustomerService = customerServiceEntity.getId();
        assertNotNull(idCustomerService);
    }

    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        Optional<Category> categoryOptional = customerServiceController.getCustomerService(idCustomerService);
        assertNotNull(categoryOptional);
        Category category = categoryOptional.get();
        assertEquals("Massage test 1", customerServiceController.getDateEnd());
    }
}
