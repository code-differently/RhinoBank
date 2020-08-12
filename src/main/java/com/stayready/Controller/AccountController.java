package com.stayready.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.stayready.Domain.Account;
import com.stayready.Exception.ResourceNotFoundException;
import com.stayready.Repositories.AccountRepository;

import java.net.URI;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;



@RestController
public class AccountController{

    @Inject
    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value="/accounts", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        Iterable<Account> allAccounts = accountRepository.findAll();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @RequestMapping(value="/accounts", method=RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        account = accountRepository.save(account);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(account.getId()).toUri();
        responseHeaders.setLocation(newAccountUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/accounts/{accountId}", method=RequestMethod.GET)
    public ResponseEntity<?> getAccount(@PathVariable Long accountId) {
        verifyAccount(accountId);
        Account a = accountRepository.findOne(accountId);

	    return new ResponseEntity<> (a, HttpStatus.OK);
    }

    @RequestMapping(value="/account/{accountId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updatePoll(@RequestBody Account account, @PathVariable Long accountId) {
        verifyAccount(accountId);
        Account a = accountRepository.save(account);
        
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @RequestMapping(value="/account/{accountId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long accountId) {
        verifyAccount(accountId);
        accountRepository.delete(accountId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Account account = accountRepository.findOne(accountId);        
        
        if(account == null)               
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");        
    }
}