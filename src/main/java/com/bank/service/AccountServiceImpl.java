package com.bank.service;

import com.bank.exception.AccountNotFoundException;
import com.bank.model.Account;
import com.bank.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public void deposit(Long fromAccountId, Long toAccountId, double amount) {
        Account fromAccount = accountRepository.findByAccountId(fromAccountId);
        Account toAccount = accountRepository.findByAccountId(toAccountId);

        if (fromAccount != null && toAccount != null) {
            boolean withdrawn = fromAccount.withdraw(amount);
            if (withdrawn) {
                accountRepository.save(fromAccount);

                // Record the withdrawal transaction for the sender
                transactionService.recordWithdrawal(fromAccountId, amount);

                // Deposit the amount into the receiver's account
                toAccount.deposit(amount);
                accountRepository.save(toAccount);

                // Record the deposit transaction for the receiver
                transactionService.recordDeposit(toAccountId, amount);
            } else {
                throw new RuntimeException("Insufficient balance for fund transfer");
            }
        } else {
            throw new AccountNotFoundException("One or both accounts not found");
        }
    }

    @Override
    public void withdraw(Long fromAccountId, Long toAccountId, double amount) {
        Account fromAccount = accountRepository.findByAccountId(fromAccountId);
        Account toAccount = accountRepository.findByAccountId(toAccountId);

        if (fromAccount != null && toAccount != null) {
            boolean withdrawn = fromAccount.withdraw(amount);
            if (withdrawn) {
                accountRepository.save(fromAccount);

                // Record the withdrawal transaction for the sender
                transactionService.recordWithdrawal(fromAccountId, amount);

                // Deposit the amount into the receiver's account
                toAccount.deposit(amount);
                accountRepository.save(toAccount);

                // Record the deposit transaction for the receiver
                transactionService.recordDeposit(toAccountId, amount);
            } else {
                throw new RuntimeException("Insufficient balance for fund transfer");
            }
        } else {
            throw new AccountNotFoundException("One or both accounts not found");
        }
    }

    
}