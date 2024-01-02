package com.bank.service;

import com.bank.model.Customer;

public interface CustomerService 
{
	Customer getCustomerById(Long customerId);

	Customer update(Long customerId, Customer customer);
}
