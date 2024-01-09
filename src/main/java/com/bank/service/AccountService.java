package com.bank.service;

import org.springframework.http.ResponseEntity;

import com.bank.model.Account;

public interface AccountService
{
	Account getAccountById(Long accountId);

	void deposit(Long fromAccountId, Long toAccountId, double amount);

	void withdraw(Long fromAccountId, Long toAccountId, double amount);
	
	
}