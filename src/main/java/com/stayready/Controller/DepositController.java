package com.stayready.Controller;

import javax.inject.Inject;

import com.stayready.Repositories.DepositRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.stayready.Domain.Deposit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import com.stayready.Exception.ResourceNotFoundException;

@RestController
public class DepositController {
    
    @Inject
    private DepositRepository depositRepository;

    @Autowired
    public DepositController(DepositRepository depositRepository){
        this.depositRepository = depositRepository;
    }

    @RequestMapping(value="/deposits", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Deposit>> getAllDeposits() {
        Iterable<Deposit> allDeposits = depositRepository.findAll();
        return new ResponseEntity<>(allDeposits, HttpStatus.OK);
    }

    @RequestMapping(value="/deposits", method=RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@RequestBody Deposit deposit) {
        URI newDepositUri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(deposit.getId())
            .toUri();
        deposit = depositRepository.save(deposit);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(newDepositUri);

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
}

    @RequestMapping(value="/deposits/{depositId}", method=RequestMethod.GET)
    public ResponseEntity<?> getDeposit(@PathVariable Long depositId) {
        verifyDeposit(depositId);
	    Deposit d = depositRepository.findOne(depositId);
	    return new ResponseEntity<> (d, HttpStatus.OK);
}

    @RequestMapping(value="/deposits/{depositId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Deposit deposit, @PathVariable Long depositId) {
        verifyDeposit(depositId);
        Deposit d = depositRepository.save(deposit);
        return new ResponseEntity<>(d, HttpStatus.OK);
}

    @RequestMapping(value="/deposits/{depositId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId) {
        verifyDeposit(depositId);
        depositRepository.delete(depositId);
        return new ResponseEntity<>(HttpStatus.OK);
}

    private void verifyDeposit(Long depositId) throws ResourceNotFoundException {
        Deposit deposit = depositRepository.findOne(depositId);
        if(deposit == null){
            throw new ResourceNotFoundException(depositId + "was not found");
        }
    }
}
