package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Account;

public interface AccountRepo extends JpaRepository<Account,Long>
{
	public Account findByAccountId(Long accountId);
	
	
}