package com.reservo.reservoback.repository;

import com.reservo.reservoback.model.CustomerServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerServiceRepository extends CrudRepository<CustomerServiceEntity, Integer> {
}
