package com.taller2.customerservice.dto;


import com.taller2.customerservice.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO customerToCustomerDTO(Customer customer);
    List<CustomerDTO> customerListToCustomerDTOList(List<Customer> customerList);
}