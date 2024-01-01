package com.bank.service;

import com.bank.model.Account;

public interface AccountService
{
	Account getAccountById(Long accountId);

	void deposit(Long accountId, double amount);

	void withdraw(Long accountId, double amount);
	
	
}