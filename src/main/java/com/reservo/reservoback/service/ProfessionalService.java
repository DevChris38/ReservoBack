package com.reservo.reservoback.service;

import com.reservo.reservoback.model.Professional;
import com.reservo.reservoback.repository.ProfessionalRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProfessionalService {
    @Autowired
    private ProfessionalRepository professionalRepository;

    public Optional<Professional> getProfessional(final Integer id) {
        return professionalRepository.findById(id);
    }

    public void deleteProfessional(final Integer id) {
        professionalRepository.deleteById(id);
    }

    public Professional saveProfessional(Professional category) {
        return professionalRepository.save(category);
    }
}
