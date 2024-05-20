package com.reservo.reservoback.repository;

import com.reservo.reservoback.model.Services;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<Services, Integer> {
}
