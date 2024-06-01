package com.taller2.customerservice.service;

import com.taller2.customerservice.dto.CustomerMapper;
import com.taller2.customerservice.dto.CustomerToSaveDTO;
import com.taller2.customerservice.dto.CustomerDTO;
import com.taller2.customerservice.entity.Customer;
import com.taller2.customerservice.repository.CustomerRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO createCustomer(CustomerToSaveDTO customerToSaveDTO) {
        Customer customer = Customer.builder()
                .fullName(customerToSaveDTO.fullName())
                .build();
        customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(customer);
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    public CustomerDTO findCustomer(UUID id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ServiceException("Customer not found"));
        return customerMapper.customerToCustomerDTO(customer);
    }

    public List<CustomerDTO> findAllCustomers() {
        return customerMapper.customerListToCustomerDTOList(customerRepository.findAll());
    }
}
