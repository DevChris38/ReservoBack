package com.reservo.reservoback.controller;

import com.reservo.reservoback.model.Services;
import com.reservo.reservoback.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    /**
     * Read - Get one service by id
     *
     * @return - A service
     */

    public Optional<Services> getService(final Integer id) {
        return serviceService.getService(id);
    }

    /**
     * Delete - Delete service
     */

    public void deleteService(final Integer id) {
        serviceService.deleteService(id);
    }

    /**
     * Create - Save service
     *
     * @return - An object of service saved
     */

    public Services saveService(Services services) {
        return serviceService.saveService(services);
    }
}
