package com.stayready.controllers;

import com.stayready.domains.Customer;
import com.stayready.exceptions.ResourceNotFoundException;
import com.stayready.repositories.CustomerRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;

public class CustomerController {

    @Inject
    private CustomerRepository customerRepository;

    @RequestMapping(value="/customers", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Iterable<Customer> allCustomers = customerRepository.findAll();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @RequestMapping(value="/customers", method=RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer) {
        customer = customerRepository.save(customer);
        //Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        responseHeaders.setLocation(newCustomerUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/customers/{customerId}", method=RequestMethod.GET)
    public ResponseEntity<?> getCustomer(@PathVariable Long customerId) {
        verifyCustomer(customerId);
        Customer a = customerRepository.findOne(customerId);
        return new ResponseEntity<> (a, HttpStatus.OK);
    }

    @RequestMapping(value="/customers/{customerId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        // Save the entity
        verifyCustomer(customerId);
        Customer a = customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/customers/{customerId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        verifyCustomer(customerId);
        customerRepository.delete(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyCustomer(Long customerId) throws ResourceNotFoundException {
        Customer customer = customerRepository.findOne(customerId);
        if(customer == null) {
            throw new ResourceNotFoundException("Customer with id " + customerId + " not found");
        }
    }
}
