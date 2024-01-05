package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Customer;
import com.bank.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    private CustomerRepo customerRepository;

    @Override
    public Customer getCustomerById(Long customerId) 
    {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    
}
