package com.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private String bankName;
	private String branchArea;
	private String branchCity;
	private String branchState;
	private String branchpincode;
	private String managername;
	private double Balance;
	private String type;
	
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
	@JsonIgnore
    private Customer customer;
	
	// Method to deposit funds
    public void deposit(double amount) {
        this.Balance += amount;
    }

    // Method to withdraw funds
    public boolean withdraw(double amount) {
        if (this.Balance >= amount) {
            this.Balance -= amount;
            return true; // Withdrawal successful
        }
        return false; // Insufficient funds
    }

    
  
    
   
    
}