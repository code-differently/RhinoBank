package com.stayready.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name="CUSTOMER_ID")
    private Long id;

    @Column(name="FIRST_NAME")

    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="ADDRESS")
   private Set<Address> address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
}
