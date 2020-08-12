package com.stayready.domains;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private long id;

    private String first_Name;
    private String last_Name;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy
    @Size(min = 2, max = 6)
    private Set<Address> address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public Set<Address> getAddresses() {
        return address;
    }

    public void setAddresses(Set<Address> addresses) {
        this.address = addresses;
    }
}
