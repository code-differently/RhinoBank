package com.stayready.Controllers;

import com.stayready.domain.Bill;
import com.stayready.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class BillController {

    private BillRepository billRepository;

    @Autowired
    public BillController(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @RequestMapping(value = "/bill", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@RequestBody Bill bill) {

        bill =  billRepository.save(bill);
        HttpHeaders responseHeaders = new HttpHeaders();

        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bill.getId())
                .toUri();

        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


}