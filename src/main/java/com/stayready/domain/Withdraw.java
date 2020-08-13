package com.stayready.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Withdraw {

    @Id
    @GeneratedValue
    @Column(name = "DEPOSIT_ID")
    private Long id;

    @Column(name = "Deposit_TYPE")
    private String type;

    @Column(name = "TRANSACTION_DATE")
    private TransactionType transaction_date;

    @Column(name = "STATUS")
    private Status status;

    @Column(name = "PAYEE_ID")
    private Long payee_id;

    @Column(name = "MEDIUM")
    private Medium medium;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DESCRIPTION")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionDate() {
        return transaction_date.getTransactionType();
    }

    public void setTransactionDate(String transaction_date) {
        this.transaction_date.setTransactionType(transaction_date);
    }

    public String getStatus() {
        return status.getStatus();
    }

    public void setStatus(String status) {
        this.status.setStatus(status);
    }

    public Long getPayeeId() {
        return payee_id;
    }

    public void setPayeeId(Long payee_id) {
        this.payee_id = payee_id;
    }

    public String getMedium() {
        return medium.getMedium();
    }

    public void setMedium(String medium) {
        this.medium.setMedium(medium);
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}