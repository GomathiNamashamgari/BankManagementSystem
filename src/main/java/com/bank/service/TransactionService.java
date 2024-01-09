package com.bank.service;

import java.util.List;

import com.bank.model.Account;
import com.bank.model.Transaction;

public interface TransactionService 
{
	

	void recordDeposit(Long toAccountId, double amount);

	void recordWithdrawal(Long fromAccountId, double amount);

	void recordTransaction(Long accountId, double amount, String type);

	List<Transaction> getTransactionsByAccount(Long accountId);


	



	




	
}
