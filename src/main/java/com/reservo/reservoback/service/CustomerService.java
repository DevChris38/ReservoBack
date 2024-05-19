package com.reservo.reservoback.service;


import com.reservo.reservoback.model.Customer;
import com.reservo.reservoback.repository.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> getCustomer(final Integer id) {
        return customerRepository.findById(id);
    }

    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(final Integer id) {
        customerRepository.deleteById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerByLastName(final String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}
