package com.reservo.reservoback.model;

import com.reservo.reservoback.model.key.CustomerServiceId;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_service")
public class CustomerServiceEntity {

    @EmbeddedId
    private CustomerServiceId id;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Services service;

    private String dateEnd;

    public CustomerServiceEntity() {
    }

    public CustomerServiceEntity(Integer customerId, String dateBeginning, Services service, String dateEnd) {
        this.id = new CustomerServiceId(customerId, dateBeginning);
        this.service = service;
        this.dateEnd = dateEnd;
    }

}
