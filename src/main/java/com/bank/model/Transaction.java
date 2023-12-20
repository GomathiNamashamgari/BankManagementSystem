package com.bank.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Transaction 
{
	@Id
	private Integer transactionId;
	private Integer transactionAmount;
	private Date transactionDate;
	private String transactionType;
	
	
	
	
	@ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;
}
