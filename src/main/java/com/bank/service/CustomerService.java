package com.bank.service;

import java.util.List;

import com.bank.model.Customer;

public interface CustomerService 
{
	public Customer getCustomerDetails(String id);
	public List<Customer> getCustomerDetails();
	public String insertCustomer(Customer c);
	public String updateCustomer(Customer c);
	public String deleteCustomer(String id); 
	public Customer getByCustomerId(String id);
	public Customer getByCustomerName(String cname);
	public Customer getByCustomerContact(Long contact);
}
