package com.reservo.reservoback.repository;

import com.reservo.reservoback.model.CustomerServiceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerServiceRepository extends CrudRepository<CustomerServiceEntity, Integer> {

    @Query
            ("SELECT c FROM CustomerServiceEntity c WHERE c.id.customerId = :id AND c.id.dateBeginning = :date")
    Optional<CustomerServiceEntity> findByCustomerIdDateBeginning(@Param("id") Integer id, @Param("date") String date);

    List<CustomerServiceEntity> findByDateEnd(String dateEnd);

    @Query
            ("SELECT c.dateEnd FROM CustomerServiceEntity c WHERE c.id.customerId = :id AND c.id.dateBeginning = :date")
    String getDateEnd(@Param("id") Integer id, @Param("date") String date);
}
