package com.taller2.customerservice.service;

import com.taller2.customerservice.dto.CustomerDTO;
import com.taller2.customerservice.dto.CustomerToSaveDTO;
import com.taller2.customerservice.entity.Customer;
import org.hibernate.service.spi.ServiceException;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerToSaveDTO customerToSaveDTO);
    void deleteCustomer(UUID id);
    CustomerDTO findCustomer(UUID id);
    List<CustomerDTO> findAllCustomers();
}
