package com.reservo.reservoback.model;

import com.reservo.reservoback.model.key.CustomerServiceId;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "customer_service")
public class CustomerServiceEntity {

    @EmbeddedId
    private CustomerServiceId id;

    @ManyToOne
    @JoinColumn(name = "id_service", nullable = false)
    private Services service;

    private LocalDate dateEnd;

    public CustomerServiceEntity() {
    }

    public CustomerServiceEntity(CustomerServiceId id, Services service, LocalDate dateEnd) {
        this.id = id;
        this.service = service;
        this.dateEnd = dateEnd;
    }
}
