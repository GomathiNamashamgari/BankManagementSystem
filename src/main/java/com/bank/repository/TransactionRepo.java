package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Account;
import com.bank.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,Long>
{
	
	List<Transaction> findByAccount_AccountId(Long accountId);
	
}

