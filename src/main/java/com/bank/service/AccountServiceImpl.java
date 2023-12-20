package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.AccountNotFoundException;
import com.bank.exception.AccountOperationException;
import com.bank.model.Account;
import com.bank.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	AccountRepo arepo;
	

	public AccountServiceImpl(AccountRepo arepo) {
		super();
		this.arepo = arepo;
	}

	@Override
	public Account getAccountDetails(String accountNumber) {
		Optional<Account> a=arepo.findById(accountNumber);
		Account a1=a.get();
		return a1;
	}

	@Override
	public List<Account> getAccountDetails() {
		List<Account> list=arepo.findAll();
		return list;
	}

	@Override
	public String insertAccount(Account a) {
		arepo.save(a);
		return "One record has been inserted into account details";
	}

	@Override
	public String update(Account a) {
		arepo.save(a);
		return "One record has been updated into account details";
	}

	@Override
	public String deleteAccount(String accountNumber) {
		arepo.deleteById(accountNumber);
		return "One record has been deleted from account relation";
	}

	@Override
	public Account getByAccountNumber(String accountNumber) {
		Account account = arepo.findByAccountNumber(accountNumber);
		return account;
	}
	
	 // Method to deposit into an account
    public String depositAmount(String accountNumber, int amount) {
    	try {
        Account account = arepo.findByAccountNumber(accountNumber);
        if (account != null) {
            account.deposit(amount);
            arepo.save(account);
            return "Amount deposited successfully.";
        }
        throw new AccountNotFoundException("Account not found");
        
        }catch(AccountNotFoundException e) {
        	throw e;
    }catch(Exception e) {
    	return "An error occurred while depositing the amount";
    }
    }

    // Method to withdraw from an account
    public String withdrawAmount(String accountNumber, int amount) {
    	try {
        Account account = arepo.findByAccountNumber(accountNumber);
        if (account != null) {
            boolean withdrawn = account.withdraw(amount);
            if (withdrawn) {
                arepo.save(account);
                return "Amount withdrawn successfully.";
            }
            return "Insufficient funds.";
        }
 throw new AccountNotFoundException("Account not found");
        
        }catch(AccountNotFoundException e) {
        	throw e;
        }catch(Exception e) {
    	throw new AccountOperationException("Error occured during withdrawal");
    }
}

	
}
