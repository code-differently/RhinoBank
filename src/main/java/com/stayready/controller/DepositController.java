package com.stayready.controller;

import com.stayready.domain.Deposit;
import com.stayready.repositories.DepositRepository;
import com.stayready.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DepositController {

    private DepositRepository depositRepository;

    @Autowired
    public DepositController(DepositRepository depositRepository){
        this.depositRepository = depositRepository;
    }

    /*@RequestMapping(value = "/accounts/{accountsId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositForSpecificAccount(@PathVariable Long accountId) {
        Account account = accountRepository.findOne(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }*/

    @RequestMapping(value = "/deposit/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositByDepositId(@PathVariable Long depositId) {
        Deposit deposit = depositRepository.findOne(depositId);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    /*@RequestMapping(value="/accounts/{accountId}", method=RequestMethod.PUT)
    public ResponseEntity<?> createDeposit(@Valid @RequestBody Account account, @PathVariable Long accountId) {
        // Save the entity
        Account a = accountRepository.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @RequestMapping(value="/deposit/{depositId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@Valid @RequestBody Deposit deposit, @PathVariable Long depositId) {
        // Save the entity
        Deposit d = depositRepository.save(deposit);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/deposit/{deposit}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId) {
        depositRepository.delete(depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@RequestMapping(value="/deposit/{deposit}", method=RequestMethod.PUT)
    public ResponseEntity<?> makeDeposit(@PathVariable Long depositId){
        depositRepository.make(depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
