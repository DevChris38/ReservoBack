package com.reservo.reservoback.model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerServiceId implements Serializable {

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "date_beginning")
    private LocalDate dateBeginning;

}
