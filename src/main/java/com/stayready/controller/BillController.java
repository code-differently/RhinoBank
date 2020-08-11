package com.stayready.controller;

import com.stayready.domain.Account;
import com.stayready.domain.Bill;
import com.stayready.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class BillController {
    private final BillRepository billRepository;

    @Autowired
    public BillController(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    //not sure if this is getting the bills from the specific account -Faith
    @GetMapping(value = "/accounts/{accountId}/bills")
    public ResponseEntity<Iterable<Bill>> getAllBills(){
        Iterable<Bill> allBills = billRepository.findAll();
        return new ResponseEntity<>(allBills, HttpStatus.OK);
    }

    @GetMapping(value = "/bills/{billId}")
    public ResponseEntity<?> getBill(@PathVariable Long billId){
        Bill bill = billRepository.findOne(billId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    //TODO: GetMapping for customer



    //not sure if this is correct - Faith
    @PostMapping(value = "/customers/{accountId}/bills")
    public ResponseEntity<?> createBill(@Valid@RequestBody Bill bill){
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

    @PutMapping(value = "/bills/{billId}")
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable Long billId){
        Bill b = billRepository.save(bill);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/bills/{billId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long billId){
        billRepository.delete(billId);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
