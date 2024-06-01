package com.taller2.customerservice.service;

import com.taller2.customerservice.dto.CustomerDto;
import com.taller2.customerservice.dto.CustomerMapper;
import com.taller2.customerservice.dto.CustomerToSaveDto;
import com.taller2.customerservice.entity.Customer;
import com.taller2.customerservice.repository.CustomerRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto createCustomer(CustomerToSaveDto customer) {
        Customer customerToSave = Customer.builder()
                .fullName(customer.fullName())
                .build();
        customerToSave = customerRepository.save(customerToSave);
        return customerMapper.customerToCustomerDTO(customerToSave);
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    public CustomerDto findCustomer(UUID id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ServiceException("Cliente no encontrado"));
        return customerMapper.customerToCustomerDTO(customer);
    }

    public List<CustomerDto> findAllCustomers() {
        return customerMapper.customerListToCustomerDTOList(customerRepository.findAll());
    }
}
