package com.stayready.Domain;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class Account {
    
    @Id
    @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private Long id; 

    @Column(name = "ACCOUNT_TYPE")
    private AccountType type;

    @Column(name = "ACCOUNT_NICKNAME")
    private String nickname;

    @Column(name = "ACCOUNT_REWARDS")
    private Integer rewards;

    @Column(name = "ACCOUNT_BALANCE")
    private Double balance;

    @Column(name = "ACCOUNT_CUSTOMER")
    private String customer;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public AccountType getType(){
        return type;
    }

    public void setType(AccountType type){
        this.type = type;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public Integer getRewards(){
        return rewards;
    }

    public void setRewards(Integer rewards){
        this.rewards = rewards;
    }

    public Double getBalance(){
        return balance;
    }

    public void setBalance(Double balance){
        this.balance = balance;
    }

    public String getCustomer(){
        return customer;
    }

    public void setCustomer(String customer){
        this.customer = customer;
    }

}
