package com.reservo.reservoback.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "professional")
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String activity;
    private String description;
    private String website;
    private String phone;
    private String adresse;

    @OneToMany(mappedBy = "professional")
    private Set<Image> images;

    public Professional() {
    }

    public Professional(String name, String activity, String description, String website, String phone, String adresse) {
        this.name = name;
        this.activity = activity;
        this.description = description;
        this.website = website;
        this.phone = phone;
        this.adresse = adresse;
    }
}
