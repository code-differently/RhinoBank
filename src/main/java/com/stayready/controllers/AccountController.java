package com.stayready.controllers;

import com.stayready.domains.Account;
import com.stayready.exceptions.ResourceNotFoundException;
import com.stayready.repositories.AccountRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;

public class AccountController {

    @Inject
    private AccountRepository accountRepository;

    @RequestMapping(value="/accounts", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        Iterable<Account> allAccounts = accountRepository.findAll();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @RequestMapping(value="/accounts", method=RequestMethod.POST)
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account) {
        account = accountRepository.save(account);
        //Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/accounts/{accountId}", method=RequestMethod.GET)
    public ResponseEntity<?> getAccount(@PathVariable Long accountId) {
        verifyAccount(accountId);
        Account a = accountRepository.findOne(accountId);
        return new ResponseEntity<> (a, HttpStatus.OK);
    }

    @RequestMapping(value="/accounts/{accountId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId) {
        // Save the entity
        verifyAccount(accountId);
        Account a = accountRepository.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/accounts/{accountId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId) {
        verifyAccount(accountId);
        accountRepository.delete(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Account account = accountRepository.findOne(accountId);
        if(account == null) {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }
}
