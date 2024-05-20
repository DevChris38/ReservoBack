package com.reservo.reservoback.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "service")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer duration;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_professional", nullable = false)
    private Professional professional;

    @OneToMany(mappedBy = "service")
    private Set<CustomerServiceEntity> customerServiceEntity;

    public Services() {
    }

    public Services(String name, Integer duration, Double price, Category category, Professional professional) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.category = category;
        this.professional = professional;
    }
}