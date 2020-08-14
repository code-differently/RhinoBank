package com.stayready.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private long id;

    @Column
    private String street_Number;

    @Column
    private String street_Name;

    @Column
    private String city;

    @Column
    private String stateN;

    @Column
    private String zip;

    public long getId() {
        return id;
    }

    public String getStreet_Number() {
        return street_Number;
    }

    public void setStreet_Number(String street_Number) {
        this.street_Number = street_Number;
    }

    public String getStreet_Name() {
        return street_Name;
    }

    public void setStreet_Name(String street_Name) {
        this.street_Name = street_Name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return stateN;
    }

    public void setState(String state) {
        this.stateN = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
