package com.reservo.reservoback.model.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CustomerServiceId implements Serializable {

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "date_beginning")
    private String dateBeginning;
}
