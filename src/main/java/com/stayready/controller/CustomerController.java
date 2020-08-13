package com.stayready.controller;

import com.stayready.domain.Customer;
import com.stayready.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

public class CustomerController {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        Iterable<Customer> allCustomers = customerRepository.findAll();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerAccount(@PathVariable Long customerId){
        verifyCustomer(customerId);
        Customer c = customerRepository.findOne(customerId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId){
        verifyCustomer(customerId);
        Customer c = customerRepository.findOne(customerId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping(value = "/customers/")
    public ResponseEntity<?> createCustomer(@Valid@RequestBody Customer customer){
        customer = customerRepository.save(customer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("")
                .buildAndExpand(customer.getId())
                .toUri();
        responseHeaders.setLocation(newCustomerUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customers/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId){
        Customer c = customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void verifyCustomer(Long customerId) throws ResourceNotFoundException{
        Customer c = customerRepository.findOne(customerId);

        if(c==null){
            throw new ResourceNotFoundException(customerId + " was not found!", null);
        }
    }


}
