package com.springframework.restmvc.mappers;


import com.springframework.restmvc.entities.Customer;
import com.springframework.restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO cutomerToCustomerDto(Customer customer);
}
