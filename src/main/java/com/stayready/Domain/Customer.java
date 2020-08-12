package com.stayready.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Customer{
    @Id 
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    public Long id;

    @Column(name = "CUSTOMER_FIRST_NAME")
    public String first_name;

    @Column(name = "CUSTOMER_LAST_NAME")
    public String last_name;

    @Column(name = "CUSTOMER_ADDRESS")
    public Set<Address> address;




    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName(){
        return first_name;
    }

    public void setFirstName(String first_name){
        this.first_name = first_name;
    }

    public String getLastName(){
        return last_name;
    }

    public void setLastName(String last_name){
        this.last_name = last_name;
    }

    public Set<Address> getAddress(){
        return address;
    }

    public void setAddress(Set<Address> address){
        this.address = address;
    }



}