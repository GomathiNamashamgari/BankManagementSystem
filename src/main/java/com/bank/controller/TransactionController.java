package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.TransactionService;
import com.bank.model.Account;
import com.bank.model.Transaction;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    
    @GetMapping("/transaction")
    public ResponseEntity<List<Transaction>> getTransactionsByAccount(@RequestParam Long accountId) {
        List<Transaction> transactions = transactionService.getTransactionsByAccount(accountId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}


