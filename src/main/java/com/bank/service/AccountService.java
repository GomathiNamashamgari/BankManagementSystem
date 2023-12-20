package com.bank.service;

import java.util.List;

import com.bank.model.Account;

public interface AccountService
{
	public Account getAccountDetails(String accountNumber);
	public List<Account> getAccountDetails();
	public String insertAccount(Account a);
	public String update(Account a);
	public String deleteAccount(String accountNumber);
	public Account getByAccountNumber(String accountNumber);
	
	public String depositAmount(String accountNumber, int amount);
	public String withdrawAmount(String accountNumber,int amount);
}