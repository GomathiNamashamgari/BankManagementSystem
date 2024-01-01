package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.repository.AccountRepo;
import com.banks.exception.AccountNotFoundException;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepository;

    @Autowired
    @Lazy
    private TransactionService transactionService;
    
    @Override
    public Account getAccountById(Long accountId) {
        return accountRepository.findByAccountId(accountId);
    }

    @Override
    public void deposit(Long accountId, double amount) {
        Account account = accountRepository.findByAccountId(accountId);
        if (account != null) {
            account.deposit(amount);
            accountRepository.save(account);

            // Record the deposit transaction
            transactionService.recordDeposit(accountId, amount);
        } else {
            throw new AccountNotFoundException("Account not found");
        }
    }

    @Override
    public void withdraw(Long accountId, double amount) {
        Account account = accountRepository.findByAccountId(accountId);
        if (account != null) {
            boolean withdrawn = account.withdraw(amount);
            if (withdrawn) {
                accountRepository.save(account);

                // Record the withdrawal transaction
                transactionService.recordWithdrawal(accountId, amount);
            } else {
                throw new RuntimeException("Insufficient balance");
            }
        } else {
            throw new AccountNotFoundException("Account not found");
        }
    }
}
