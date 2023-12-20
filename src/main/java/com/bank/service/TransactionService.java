package com.bank.service;

import java.util.List;

import com.bank.model.Transaction;

public interface TransactionService 
{
	public Transaction getTransactionDetails(Integer id);
	public List<Transaction> getTransactionDetails();
	public String insertTransaction(Transaction t);
	public String updateTransaction(Transaction t);
	public String deleteTransaction(Integer id);
	public Transaction getByTransactionId(Integer id);
}
