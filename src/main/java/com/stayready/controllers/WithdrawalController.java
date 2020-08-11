package com.stayready.controllers;

import com.stayready.domains.Withdrawal;
import com.stayready.exceptions.ResourceNotFoundException;
import com.stayready.repositories.WithdrawalRepository;
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

public class WithdrawalController {

    @Inject
    private WithdrawalRepository withdrawalRepository;

    @RequestMapping(value="/withdrawals", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals() {
        Iterable<Withdrawal> allWithdrawals = withdrawalRepository.findAll();
        return new ResponseEntity<>(allWithdrawals, HttpStatus.OK);
    }

    @RequestMapping(value="/withdrawals", method=RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@Valid @RequestBody Withdrawal withdrawal) {
        withdrawal = withdrawalRepository.save(withdrawal);
        //Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newWithdrawalUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(withdrawal.getId())
                .toUri();
        responseHeaders.setLocation(newWithdrawalUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/withdrawals/{withdrawalId}", method=RequestMethod.GET)
    public ResponseEntity<?> getWithdrawal(@PathVariable Long withdrawalId) {
        verifyWithdrawal(withdrawalId);
        Withdrawal a = withdrawalRepository.findOne(withdrawalId);
        return new ResponseEntity<> (a, HttpStatus.OK);
    }

    @RequestMapping(value="/withdrawals/{withdrawalId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId) {
        // Save the entity
        verifyWithdrawal(withdrawalId);
        Withdrawal a = withdrawalRepository.save(withdrawal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/withdrawals/{withdrawalId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId) {
        verifyWithdrawal(withdrawalId);
        withdrawalRepository.delete(withdrawalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyWithdrawal(Long withdrawalId) throws ResourceNotFoundException {
        Withdrawal withdrawal = withdrawalRepository.findOne(withdrawalId);
        if(withdrawal == null) {
            throw new ResourceNotFoundException("Withdrawal with id " + withdrawalId + " not found");
        }
    }
}
