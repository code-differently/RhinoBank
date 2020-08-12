package com.stayready.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Deposit{

    @Id
    @GeneratedValue
    @Column(name = "DEPOSIT_ID")
    private Long id;

    @Column(name = "DEPOSIT_TYPE")
    private String type;

    @Column(name = "DEPOSIT_TRANSACATION_DATE")
    private String transaction_date;

    @Column(name = "DEPOSIT_STATUS")
    private String status;

    @Column(name = "DEPOSIT_PAYEE_ID")
    private Long payee_id;

    @Column(name = "DEPOSIT_MEDIUM")
    private String medium;

    @Column(name = "DEPOSIT_AMOUNT")
    private Double amount;

    @Column(name = "DEPOSIT_DESCRIPTION")
    private String description;



    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDepositType(){
        return type;
    }

    public void setDepositType(String type){
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

    public Long getPayeeId(){
        return payee_id;
    }

    public void setPayeeId(Long payee_id){
        this.payee_id = payee_id;
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
