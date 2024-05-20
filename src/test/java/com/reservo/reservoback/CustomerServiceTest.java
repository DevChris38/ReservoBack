package com.reservo.reservoback;

import com.reservo.reservoback.controller.CustomerServiceController;
import com.reservo.reservoback.controller.ServiceController;
import com.reservo.reservoback.model.CustomerServiceEntity;
import com.reservo.reservoback.model.key.CustomerServiceId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ReservoBackApplication.class)
@Transactional
public class CustomerServiceTest {
    @Autowired
    private CustomerServiceController customerServiceController;

    @Autowired
    private ServiceController serviceController;

    private CustomerServiceId idCustomerService;

    String now = "Maintenant";
    String tomorrow = "Demain";

    @BeforeEach
    public void setUp() throws Exception {

        CustomerServiceEntity customerServiceEntity = new CustomerServiceEntity(1, now, serviceController.getService(1).orElseThrow(() -> new RuntimeException("Category not found")), tomorrow);
        //save user, verify has ID value after save
        this.customerServiceController.saveCustomerService(customerServiceEntity);
        idCustomerService = customerServiceEntity.getId();
        assertNotNull(idCustomerService);
    }

    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        Optional<CustomerServiceEntity> customerServiceOptional = customerServiceController.getCustomerService(idCustomerService);
        assertNotNull(customerServiceOptional);
        assertEquals(tomorrow, customerServiceController.getDateEnd(idCustomerService));
    }
}
