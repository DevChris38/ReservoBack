package com.reservo.reservoback;

import com.reservo.reservoback.controller.CategoryController;
import com.reservo.reservoback.controller.CustomerController;
import com.reservo.reservoback.model.Category;
import com.reservo.reservoback.model.Customer;
import com.reservo.reservoback.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
@RestController
public class ReservoBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservoBackApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerController customerController;

    @Autowired
    private CategoryController categoryController;

    Customer customer1;

    @PostConstruct
    public void init() {
        customer1 = customerRepository.findByLastName("arthaud");
    }

    @GetMapping("hello")
    public Object sayHello() {
        return customerController.getCustomer(1).isPresent() ? customerController.getCustomer(1) : "Customer not found";
    }

    @GetMapping("/customer")
    public String sayCustomer() {
        return customerController.getCustomers().toString();
    }

    @GetMapping("/category")
    public Optional<Category> sayCategory() {
        return categoryController.getCategory(1);
    }
}
