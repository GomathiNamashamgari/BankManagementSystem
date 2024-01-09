package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @PostMapping("/deposit/{fromAccountId}/{toAccountId}/{amount}")
    public void deposit(@PathVariable Long fromAccountId,@PathVariable Long toAccountId , @PathVariable double amount) {
        accountService.deposit(fromAccountId,toAccountId, amount);
    }

    @PostMapping("/withdraw/{fromAccountId}/{toAccountId}/{amount}")
    public void withdraw(@PathVariable Long fromAccountId,@PathVariable Long toAccountId,@PathVariable double amount) {
        accountService.withdraw(fromAccountId,toAccountId, amount);
    }

   

}
