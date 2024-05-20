package com.reservo.reservoback.controller;

import com.reservo.reservoback.model.CustomerServiceEntity;
import com.reservo.reservoback.service.CustomerServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerServiceController {
    @Autowired
    private CustomerServiceService customerServiceService;

    public Optional<CustomerServiceEntity> getCustomerService(final Integer id) {
        return customerServiceService.getCustomerService(id);
    }

    public void deleteCustomerService(final Integer id) {
        customerServiceService.deleteCustomerService(id);
    }

    public CustomerServiceEntity saveCustomerService(CustomerServiceEntity customerServiceEntity) {
        return customerServiceService.saveCustomerService(customerServiceEntity);
    }
}
