package com.bank.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String name;
	private Date dateofbirth;
	private Long contact;
	private String address;
	
	
	 @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	 private List<Account> accounts;
	
	
}

