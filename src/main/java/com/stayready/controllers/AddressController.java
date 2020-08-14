package com.stayready.controllers;

import com.stayready.domains.Address;
import com.stayready.exceptions.ResourceNotFoundException;
import com.stayready.repositories.AddressRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class AddressController {

    @Inject
    private AddressRepository addressRepository;

    @RequestMapping(value="/addresses", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Address>> getAllAddresss() {
        Iterable<Address> allAddresses = addressRepository.findAll();
        return new ResponseEntity<>(allAddresses, HttpStatus.OK);
    }

    @RequestMapping(value="/addresses", method=RequestMethod.POST)
    public ResponseEntity<?> createAddress(@Valid @RequestBody Address address) {
        address = addressRepository.save(address);
        //Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAddressUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(address.getId())
                .toUri();
        responseHeaders.setLocation(newAddressUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/addresses/{addressId}", method=RequestMethod.GET)
    public ResponseEntity<?> getAddress(@PathVariable Long addressId) {
        verifyAddress(addressId);
        Address a = addressRepository.findOne(addressId);
        return new ResponseEntity<> (a, HttpStatus.OK);
    }

    @RequestMapping(value="/addresses/{addressId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateAddress(@RequestBody Address address, @PathVariable Long addressId) {
        // Save the entity
        verifyAddress(addressId);
        Address a = addressRepository.save(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/address/{addressId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteAddress(@PathVariable Long addressId) {
        verifyAddress(addressId);
        addressRepository.delete(addressId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyAddress(Long addressId) throws ResourceNotFoundException {
        Address address = addressRepository.findOne(addressId);
        if(address == null) {
            throw new ResourceNotFoundException("Address with id " + addressId + " not found");
        }
    }
}
