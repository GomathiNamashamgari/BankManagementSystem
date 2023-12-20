package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Customer;
import com.bank.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	CustomerRepo crepo;
	

	public CustomerServiceImpl(CustomerRepo crepo) {
		super();
		this.crepo = crepo;
	}

	@Override
	public Customer getCustomerDetails(String id) {
		Optional<Customer> c=crepo.findById(id);
		Customer c1=c.get();
		return c1;
	}

	@Override
	public List<Customer> getCustomerDetails() {
		List<Customer> list= crepo.findAll();
		return list;
	}

	@Override
	public String insertCustomer(Customer c) {
		crepo.save(c);
		return "One record has been inserted into Customer relation";
	}

	@Override
	public String updateCustomer(Customer c) {
		crepo.save(c);
		return "One record has been updated into Customer relation";
	}
	
	@Override
	public String deleteCustomer(String id) {
		crepo.deleteById(id);
		return "One record has been deleted";
	}

	@Override
	public Customer getByCustomerId(String id) {
		Customer customer = crepo.findByCustomerId(id);
		return customer;
	}

	@Override
	public Customer getByCustomerName(String cname) {
		Customer customer = crepo.findByCustomerName(cname);
		return customer;
	}

	@Override
	public Customer getByCustomerContact(Long contact) {
		Customer customer = crepo.findByCustomerContact(contact);
		return customer;
	}
	
}
