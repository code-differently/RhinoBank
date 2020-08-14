package com.stayready.domain;

import javax.persistence.*;

@Entity
public class Account
{
    @Id
    @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(name = "ACCOUNT_TYPE")
    private AccountType accountType;

    @Column(name = "NICK_NAME")
    private String nickName;

    @Column(name = "REWARDS")
    private Integer rewards;

    @Column(name = "BALANCE")
    private Double balance;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public AccountType getAccountType()
    {
        return accountType;
    }

    public void setAccountType(AccountType accountType)
    {
        this.accountType = accountType;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer()
    {
        return customer;
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
