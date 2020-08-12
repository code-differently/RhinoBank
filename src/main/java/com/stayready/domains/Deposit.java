package com.stayready.domains;

import com.stayready.enums.BillStatus;
import com.stayready.enums.MediumType;
import com.stayready.enums.TransactionType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Deposit {

    @Id
    @GeneratedValue
    @Column(name = "DEPOSIT_ID")
    private long id;

    private TransactionType type;
    private String transaction_Date;
    private BillStatus status;
    private long payee_Id;
    private MediumType medium;
    private double amount;
    private String description;

    public long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getTransaction_Date() {
        return transaction_Date;
    }

    public void setTransaction_Date(String transaction_Date) {
        this.transaction_Date = transaction_Date;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public long getPayee_Id() {
        return payee_Id;
    }

    public void setPayee_Id(long payee_Id) {
        this.payee_Id = payee_Id;
    }

    public MediumType getMedium() {
        return medium;
    }

    public void setMedium(MediumType medium) {
        this.medium = medium;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
