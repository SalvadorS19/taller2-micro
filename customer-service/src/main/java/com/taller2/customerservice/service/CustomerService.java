package com.taller2.customerservice.service;

import com.taller2.customerservice.dto.CustomerDto;
import com.taller2.customerservice.dto.CustomerToSaveDto;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerDto createCustomer(CustomerToSaveDto customerToSaveDTO);
    void deleteCustomer(UUID id);
    CustomerDto findCustomer(UUID id);
    List<CustomerDto> findAllCustomers();
}
