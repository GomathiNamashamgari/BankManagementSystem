package com.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>
{

	Optional<Customer> findById(Long customerId);

	

	

	
	
}
