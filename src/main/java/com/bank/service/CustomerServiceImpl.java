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

    @Override
    public Customer update(Long customerId, Customer customer) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        existingCustomer.setName(customer.getName());
        existingCustomer.setDateofbirth(customer.getDateofbirth());
        existingCustomer.setContact(customer.getContact());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setState(customer.getState());
        existingCustomer.setPincode(customer.getPincode());
        return customerRepository.save(existingCustomer);
    }
}
