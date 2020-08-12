package com.stayready.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.stayready.Domain.Bill;
import com.stayready.Repositories.BillRepository;
import javax.inject.Inject;
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
public class BillController {
    
    @Inject
    private BillRepository billRepository;

    @Autowired
    public BillController(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    @RequestMapping(value="/bills", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBills() {
        Iterable<Bill> allBills = billRepository.findAll();
        return new ResponseEntity<>(allBills, HttpStatus.OK);
    }

    @RequestMapping(value="/bills", method=RequestMethod.POST)
    public ResponseEntity<?> createBill(@RequestBody Bill bill) {
        URI newBillUri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(bill.getId())
            .toUri();
        bill = billRepository.save(bill);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(newBillUri);

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
}

    @RequestMapping(value="/bills/{billId}", method=RequestMethod.GET)
    public ResponseEntity<?> getBill(@PathVariable Long billId) {
        verifyBill(billId);
	    Bill b = billRepository.findOne(billId);
	    return new ResponseEntity<> (b, HttpStatus.OK);
}

    @RequestMapping(value="/bills/{billId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable Long billId) {
        verifyBill(billId);
        Bill b = billRepository.save(bill);
        return new ResponseEntity<>(b, HttpStatus.OK);
}

    @RequestMapping(value="/bills/{billId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable Long billId) {
        verifyBill(billId);
        billRepository.delete(billId);
        return new ResponseEntity<>(HttpStatus.OK);
}

    private void verifyBill(Long billId) throws ResourceNotFoundException {
        Bill bill = billRepository.findOne(billId);
        if(bill == null){
            throw new ResourceNotFoundException(billId + "was not found");
        }
    }

}