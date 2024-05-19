package com.reservo.reservoback;

import com.reservo.reservoback.controller.CustomerController;
import com.reservo.reservoback.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ReservoBackApplication.class)
@Transactional
class CustomerTest {
    @Autowired
    private CustomerController customerController;

    @BeforeEach
    public void setUp() throws Exception {
        Customer user1 = new Customer("Vincent", "jétorisque", "0606060606", "vincent@alesia.com", "NikLéRom1");
        Customer user2 = new Customer("Gabrielle", "gay", "0634360498", "gabrielle.gay1991@gmail.com", "Eti6h8zc");
        //save user, verify has ID value after save
        assertNull(user1.getId());
        assertNull(user2.getId());//null before save
        this.customerController.saveCustomer(user1);
        this.customerController.saveCustomer(user2);
        assertNotNull(user1.getId());
        assertNotNull(user2.getId());
    }

    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        Customer customerA = customerController.getCustomerByLastName("jétorisque");
        assertNotNull(customerA);
        assertEquals("Vincent", customerA.getFirstName());
    }
}