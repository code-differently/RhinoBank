package com.stayready.Controller;

import javax.inject.Inject;
import java.net.URI;

import com.stayready.Repositories.WithdrawalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RestController;
import com.stayready.Domain.Withdrawal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import com.stayready.Exception.ResourceNotFoundException;

@RestController
public class WithdrawalController {
    
    @Inject
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    public WithdrawalController(WithdrawalRepository withdrawalRepository){
        this.withdrawalRepository = withdrawalRepository;
    }

    @RequestMapping(value="/withdrawals", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals() {
        Iterable<Withdrawal> allWithdrawals = withdrawalRepository.findAll();
        return new ResponseEntity<>(allWithdrawals, HttpStatus.OK);
    }

    @RequestMapping(value="/accounts", method=RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@RequestBody Withdrawal withdrawal) {
        withdrawal = withdrawalRepository.save(withdrawal);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newWithdrawalUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(withdrawal.getId()).toUri();
        responseHeaders.setLocation(newWithdrawalUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/withdrawals/{withdrawalId}", method=RequestMethod.GET)
    public ResponseEntity<?> getWithdrawal(@PathVariable Long withdrawalId) {
        verifyWithdrawal(withdrawalId);
	    Withdrawal w = withdrawalRepository.findOne(withdrawalId);
	    return new ResponseEntity<> (w, HttpStatus.OK);
}

    @RequestMapping(value="/withdrawals/{withdrawalId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId) {
        verifyWithdrawal(withdrawalId);
        Withdrawal w = withdrawalRepository.save(withdrawal);
        return new ResponseEntity<>(w, HttpStatus.OK);
}

    @RequestMapping(value="/withdrawals/{withdrawalId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long withdrawalId) {
        verifyWithdrawal(withdrawalId);
        withdrawalRepository.delete(withdrawalId);
        return new ResponseEntity<>(HttpStatus.OK);
}

    private void verifyWithdrawal(Long withdrawalId) throws ResourceNotFoundException {
        Withdrawal withdrawal = withdrawalRepository.findOne(withdrawalId);
        if(withdrawal == null){
            throw new ResourceNotFoundException("Withdrawal with id " + withdrawalId + "was not found");
        }
    }
}