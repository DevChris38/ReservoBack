package com.reservo.reservoback.controller;

import com.reservo.reservoback.model.Professional;
import com.reservo.reservoback.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProfessionalController {
    @Autowired
    private ProfessionalService professionalService;

    public Optional<Professional> getProfessional(final Integer id) {
        return professionalService.getProfessional(id);
    }

    public void deleteCategory(final Integer id) {
        professionalService.deleteProfessional(id);
    }

    public Professional saveProfessional(Professional professional) {
        return professionalService.saveProfessional(professional);
    }
}
