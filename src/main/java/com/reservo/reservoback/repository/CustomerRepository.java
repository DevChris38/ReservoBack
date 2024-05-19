package com.reservo.reservoback.repository;

import com.reservo.reservoback.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findByLastName(String lastName);
}
