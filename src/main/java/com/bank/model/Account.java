package com.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Account 
{
	@Id
	private String accountNumber;
	private String accountStatus;
	private String accountType;
	private Integer accountBalance;
	//private Integer transactionId;
	
	
	
	// Method to deposit funds
    public void deposit(int amount) {
        this.accountBalance += amount;
    }

    // Method to withdraw funds
    public boolean withdraw(int amount) {
        if (this.accountBalance >= amount) {
            this.accountBalance -= amount;
            return true; // Withdrawal successful
        }
        return false; // Insufficient funds
    }
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    /*
    @OneToMany()
    private List<Transaction> transactions;
    
    */
    
}