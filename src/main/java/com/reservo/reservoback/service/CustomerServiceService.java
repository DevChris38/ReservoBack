package com.reservo.reservoback.service;

import com.reservo.reservoback.model.CustomerServiceEntity;
import com.reservo.reservoback.model.key.CustomerServiceId;
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

    public Optional<CustomerServiceEntity> getCustomerService(final CustomerServiceId id) {
        return customerServiceRepository.findByCustomerIdDateBeginning(id.getCustomerId(), id.getDateBeginning());
    }

    public void deleteCustomerService(final Integer id) {
        customerServiceRepository.deleteById(id);
    }

    public CustomerServiceEntity saveCustomerService(CustomerServiceEntity customerServiceEntity) {
        return customerServiceRepository.save(customerServiceEntity);
    }

    public String getDateEnd(final CustomerServiceId id) {
        return customerServiceRepository.getDateEnd(id.getCustomerId(), id.getDateBeginning());
    }
}
