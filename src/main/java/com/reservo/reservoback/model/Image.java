package com.reservo.reservoback.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String link;

    @ManyToOne
    @JoinColumn(name = "id_professional", nullable = false)
    private Professional professional;

    public Image() {
    }

    public Image(String link, Professional professional) {
        this.link = link;
        this.professional = professional;
    }
}
