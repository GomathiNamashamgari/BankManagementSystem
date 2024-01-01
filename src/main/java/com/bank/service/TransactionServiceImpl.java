package com.bank.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.AccountNotFoundException;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepo transactionRepository;

    @Autowired
    private AccountService accountService;
    
    @Override
    public List<Transaction> getTransactionsByAccount(Long accountId) 
    {
        return transactionRepository.findByAccount_AccountId(accountId);
    }

    @Override
    public void recordDeposit(Long accountId, double amount) {
        recordTransaction(accountId, amount, "DEPOSIT");
    }

    @Override
    public void recordWithdrawal(Long accountId, double amount) {
        recordTransaction(accountId, amount, "WITHDRAW");
    }

    @Override
    public void recordTransaction(Long accountId, double amount, String type) {
        // Fetch the Account entity from the database
        Account account = accountService.getAccountById(accountId);

        // Check if the account is found
        if (account != null) {
            Transaction transaction = new Transaction();
            transaction.setAccount(account);
            transaction.setAmount(amount);
            transaction.setType(type);
            transaction.setTimestamp(new Date());
            transactionRepository.save(transaction);
        } else {
            throw new AccountNotFoundException("Account not found");
        }
    }
}
