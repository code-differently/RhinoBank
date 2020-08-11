package com.stayready.controller;

import com.stayready.domain.Withdraw;
import com.stayready.repositories.WithdrawRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;

@RestController
public class WithdrawController {

    @Inject
    private WithdrawRepository withdrawRepository;

    @Autowired
    public WithdrawController(WithdrawRepository withdrawRepository){

        this.withdrawRepository = withdrawRepository;
    }

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Withdraw>> getAllWithdrawals(){

        Iterable<Withdraw> allWithdraws = withdrawRepository.findAll();
        return new ResponseEntity<>(allWithdraws, HttpStatus.OK);
    }

    @RequestMapping(value = "/withdrawals/{withdrawId}", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawal(@PathVariable Long withdrawId){

        Withdraw w = withdrawRepository.findOne(withdrawId);
        return new ResponseEntity<>(w, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@RequestBody Withdraw withdraw){

        withdraw = withdrawRepository.save(withdraw);
        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(withdraw.getId()).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "withdrawals/{withdrawalId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawal(@PathVariable Long withdrawId, @RequestBody Withdraw withdraw){

        Withdraw w = withdrawRepository.save(withdraw);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawId){

        withdrawRepository.delete(withdrawId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
