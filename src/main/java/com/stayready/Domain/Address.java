package com.stayready.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address{

    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private Long id; 

    @Column(name = "STREET_NUMBER")
    private String street_number;

    @Column(name = "STREET_NAME")
    private String street_name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP")
    private String zip;

    public void setId(Long id){
        this.id = id;
    }

    public void setStreeetNumber(String street_number){
        this.street_number = street_number;
    }

    public void setStreetName(String street_name){
        this.street_name = street_name;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZip(String zip){
        this.zip = zip;
    }

    public Long getId(){
        return id;
    }

    public String getStreetNumber(){
        return street_number;
    }

    public String getStreetName(){
        return street_name;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getZip(){
        return zip;
    }
}