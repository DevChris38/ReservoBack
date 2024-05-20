package com.reservo.reservoback.service;

import com.reservo.reservoback.model.CustomerServiceEntity;
import com.reservo.reservoback.repository.CustomerServiceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CustomerServiceService {

    @Autowired
    private CustomerServiceRepository customerServiceRepository;

    public Optional<CustomerServiceEntity> getCustomerService(final Integer id) {
        return customerServiceRepository.findById(id);
    }

    public void deleteCustomerService(final Integer id) {
        customerServiceRepository.deleteById(id);
    }

    public CustomerServiceEntity saveCustomerService(CustomerServiceEntity customerServiceEntity) {
        return customerServiceRepository.save(customerServiceEntity);
    }
}
