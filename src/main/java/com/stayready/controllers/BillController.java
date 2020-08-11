package com.stayready.controllers;

import com.stayready.domains.Bill;
import com.stayready.exceptions.ResourceNotFoundException;
import com.stayready.repositories.BillRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class BillController {

    @Inject
    private BillRepository billRepository;

    @RequestMapping(value="/bills", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBills() {
        Iterable<Bill> allBills = billRepository.findAll();
        return new ResponseEntity<>(allBills, HttpStatus.OK);
    }

    @RequestMapping(value="/bills", method=RequestMethod.POST)
    public ResponseEntity<?> createBill(@Valid @RequestBody Bill bill) {
        bill = billRepository.save(bill);
        //Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBillUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bill.getId())
                .toUri();
        responseHeaders.setLocation(newBillUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/bills/{billId}", method=RequestMethod.GET)
    public ResponseEntity<?> getBill(@PathVariable Long billId) {
        verifyBill(billId);
        Bill a = billRepository.findOne(billId);
        return new ResponseEntity<> (a, HttpStatus.OK);
    }

    @RequestMapping(value="/bills/{billId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable Long billId) {
        // Save the entity
        verifyBill(billId);
        Bill a = billRepository.save(bill);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/bills/{billId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable Long billId) {
        verifyBill(billId);
        billRepository.delete(billId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyBill(Long billId) throws ResourceNotFoundException {
        Bill bill = billRepository.findOne(billId);
        if(bill == null) {
            throw new ResourceNotFoundException("Bill with id " + billId + " not found");
        }
    }
}
