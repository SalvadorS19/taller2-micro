package com.taller2.customerservice.controller;

import com.taller2.customerservice.service.CustomerService;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
}
