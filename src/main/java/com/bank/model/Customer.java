package com.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Customer 
{
	@Id
	private String customerId;
	private String customerName;
	private Long customerContact;
	private String customerAddress;
	//private String accountNumber;
	
	
	
	@ManyToOne
	@JoinColumn(name="manager_id")
	private BranchManager manager;
	
	
	
}

