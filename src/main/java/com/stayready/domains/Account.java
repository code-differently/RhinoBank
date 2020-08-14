package com.stayready.domains;

import com.stayready.enums.AccountType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private long id;

    @Column(name = "BALANCE")
    @NotEmpty
    private double balance;

    private AccountType type;
    private String nickname;
    private int rewards;

    @OneToOne
    private Customer customer;

    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getRewards() {
        return rewards;
    }

    public void setRewards(int rewards) {
        this.rewards = rewards;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
