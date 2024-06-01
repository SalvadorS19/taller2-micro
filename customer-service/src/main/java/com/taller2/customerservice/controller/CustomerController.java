package com.taller2.customerservice.controller;

import com.taller2.customerservice.dto.CustomerDTO;
import com.taller2.customerservice.dto.CustomerToSaveDTO;
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
    public CustomerDTO create(@RequestBody CustomerToSaveDTO customerToSaveDTO) {
        return customerService.createCustomer(customerToSaveDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable UUID id) {
        return customerService.findCustomer(id);
    }

    @GetMapping
    public List<CustomerDTO> findAll() {
        return customerService.findAllCustomers();
    }
}
