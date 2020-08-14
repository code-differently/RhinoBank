package com.stayready.controller;

import com.stayready.domain.Account;
import com.stayready.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController
{
    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        Iterable<Account> allAccounts = accountRepository.findAll();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }
    /*

    TODO: get all accounts for customer
    TODO: Create an account (need customer done first)

     */

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccount(@PathVariable Long accountId) {
        verifyAccount(accountId);
        Account a = accountRepository.findOne(accountId);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId) {
        // Save the entity
        verifyAccount(accountId);
        Account p = accountRepository.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId) {
        verifyAccount(accountId);
        accountRepository.delete(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void verifyAccount(Long accountId) throws ResourceNotFoundException
    {
        Account a = accountRepository.findOne(accountId);

        if(a == null) {
            throw new ResourceNotFoundException(accountId + " was not found!", null);
        }
    }
}
