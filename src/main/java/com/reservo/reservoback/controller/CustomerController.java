package com.reservo.reservoback.controller;

import com.reservo.reservoback.model.Customer;
import com.reservo.reservoback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Read - Get one customer by id
     *
     * @return - A  Customer
     */

    public Optional<Customer> getCustomer(final Integer id) {
        return customerService.getCustomer(id);
    }

    /**
     * Read - Get all customers
     *
     * @return - An Iterable object of Customer full filled
     */

    public Iterable<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    /**
     * Delete - Delete customer
     */

    public void deleteCustomer(final Integer id) {
        customerService.deleteCustomer(id);
    }

    /**
     * Create - Save customer
     *
     * @return - An object of Customer saved
     */

    public Customer saveCustomer(Customer customer) {
        return customerService.saveCustomer(customer);
    }

    /**
     * Read - get customer by lastname
     *
     * @return - An object of Customer searched
     */

    public Customer getCustomerByLastName(final String lastName) {
        return customerService.getCustomerByLastName(lastName);
    }
}
