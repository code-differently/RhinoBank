package com.stayready.controller;

import com.stayready.domain.Deposit;
import com.stayready.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;

public class DepositController {
    @Inject
    private DepositRepository depositRepository;

    @Autowired
    public DepositController(DepositRepository depositRepository){

        this.depositRepository = depositRepository;
    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Deposit>> getAllDeposits(){

        Iterable<Deposit> allDeposits = depositRepository.findAll();
        return new ResponseEntity<>(allDeposits, HttpStatus.OK);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDeposit(@PathVariable Long depositId){

        Deposit d = depositRepository.findOne(depositId);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@PathVariable Long accountId, @RequestBody Deposit deposit){

        deposit = depositRepository.save(deposit);
        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(deposit.getId()).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@PathVariable Long depositId, @RequestBody Deposit deposit){

        Deposit d = depositRepository.save(deposit);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId){

        depositRepository.delete(depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
