package com.reservo.reservoback.service;

import com.reservo.reservoback.model.Services;
import com.reservo.reservoback.repository.ServiceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Optional<Services> getService(final Integer id) {
        return serviceRepository.findById(id);
    }

    public void deleteService(final Integer id) {
        serviceRepository.deleteById(id);
    }

    public Services saveService(Services services) {
        return serviceRepository.save(services);
    }

}
