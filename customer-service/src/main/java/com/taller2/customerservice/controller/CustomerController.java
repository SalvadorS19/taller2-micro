package com.taller2.customerservice.controller;

import com.taller2.customerservice.dto.CustomerDto;
import com.taller2.customerservice.dto.CustomerToSaveDto;
import com.taller2.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDto create(@RequestBody CustomerToSaveDto customerToSaveDTO) {
        return customerService.createCustomer(customerToSaveDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable UUID id) {
        return customerService.findCustomer(id);
    }

    @GetMapping
    public List<CustomerDto> findAll() {
        return customerService.findAllCustomers();
    }
}
