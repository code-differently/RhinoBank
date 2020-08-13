package com.stayready.controller;

import com.stayready.domain.Account;
import com.stayready.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AccountController {
    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountById(@PathVariable Long accountId) {
        Account account = accountRepository.findOne(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
//
//    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
//    public Iterable<Account> getAllAccountsForCustomer(@PathVariable Long customerId) {
//        return accountRepository.findAccountsByCustomerId(customerId);
//    }

//    @RequestMapping("/customers/{customerId}/accounts", method = RequestMethod.POST)
//    public ResponseEntity<?> createAccount(@Valid @RequestBody Long customerId) {
//        Account account = accountRepository.save(customerId);
//        return new ResponseEntity<>(account, HttpStatus.OK);
//    }

    @RequestMapping(value="/accounts/{accountId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@Valid @RequestBody Account account, @PathVariable Long accountId) {
        // Save the entity
        Account a = accountRepository.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/accounts/{accounts}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId) {
        accountRepository.delete(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
