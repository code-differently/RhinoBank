package com.stayready.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Withdrawal{

    @Id
    @GeneratedValue
    @Column(name = "WITHDRAWAL_ID")
    private Long id;

    @Column(name = "WITHDRAWAL_TYPE")
    private String type;

    @Column(name = "WITHDRAWAL_TRANSACATION_DATE")
    private String transaction_date;

    @Column(name = "WITHDRAWAL_STATUS")
    private String status;

    @Column(name = "WITHDRAWAL_PAYER_ID")
    private Long payer_id;

    @Column(name = "WITHDRAWAL_MEDIUM")
    private String medium;

    @Column(name = "WITHDRAWAL_AMOUNT")
    private Double amount;

    @Column(name = "WITHDRAWAL_DESCRIPTION")
    private String description;



    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getWithdrawalType(){
        return type;
    }

    public void setWithdrawalType(String type){
        this.type = type;
    }

    public String getTransactionDate(){
        return transaction_date;
    }

    public void setTransactionDate(String transaction_date){
        this.transaction_date = transaction_date;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Long getPayerId(){
        return payer_id;
    }

    public void setPayerId(Long payer_id){
        this.payer_id = payer_id;
    }

    public String getMedium(){
        return medium;
    }

    public void setMedium(String medium){
        this.medium = medium;
    }

    public Double getAmount(){
        return amount;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
    