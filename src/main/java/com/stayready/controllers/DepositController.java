package com.stayready.controllers;

import com.stayready.domains.Deposit;
import com.stayready.exceptions.ResourceNotFoundException;
import com.stayready.repositories.DepositRepository;
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

public class DepositController {

    @Inject
    private DepositRepository depositRepository;

    @RequestMapping(value="/deposits", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Deposit>> getAllDeposits() {
        Iterable<Deposit> allDeposits = depositRepository.findAll();
        return new ResponseEntity<>(allDeposits, HttpStatus.OK);
    }

    @RequestMapping(value="/deposits", method=RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@Valid @RequestBody Deposit deposit) {
        deposit = depositRepository.save(deposit);
        //Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newDepositUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(deposit.getId())
                .toUri();
        responseHeaders.setLocation(newDepositUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/deposits/{depositId}", method=RequestMethod.GET)
    public ResponseEntity<?> getDeposit(@PathVariable Long depositId) {
        verifyDeposit(depositId);
        Deposit a = depositRepository.findOne(depositId);
        return new ResponseEntity<> (a, HttpStatus.OK);
    }

    @RequestMapping(value="/deposits/{depositId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId) {
        // Save the entity
        verifyDeposit(depositId);
        Deposit a = depositRepository.save(deposit);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/deposits/{depositId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId) {
        verifyDeposit(depositId);
        depositRepository.delete(depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyDeposit(Long depositId) throws ResourceNotFoundException {
        Deposit deposit = depositRepository.findOne(depositId);
        if(deposit == null) {
            throw new ResourceNotFoundException("Deposit with id " + depositId + " not found");
        }
    }
}
