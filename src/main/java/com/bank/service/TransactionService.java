package com.bank.service;

import java.util.List;

import com.bank.model.Account;
import com.bank.model.Transaction;

public interface TransactionService 
{
	List<Transaction> getTransactionsByAccount(Long accountId);

	void recordDeposit(Long accountId, double amount);

	void recordWithdrawal(Long accountId, double amount);

	void recordTransaction(Long accountId, double amount, String type);




	
}
