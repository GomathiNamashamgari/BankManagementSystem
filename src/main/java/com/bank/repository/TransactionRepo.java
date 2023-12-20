package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,Integer>
{
	public Transaction findByTransactionId(Integer id);
}

