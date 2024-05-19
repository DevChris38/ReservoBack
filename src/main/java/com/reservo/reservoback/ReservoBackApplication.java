package com.reservo.reservoback;

import com.reservo.reservoback.model.Customer;
import com.reservo.reservoback.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ReservoBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservoBackApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;

    Customer customer1;

    @PostConstruct
    public void init() {
        customer1 = customerRepository.findByLastName("arthaud");
    }

    @GetMapping("hello")
    public String sayHello() {
        return customer1 != null ? customer1.getFirstName() : "Customer not found";
    }
}
