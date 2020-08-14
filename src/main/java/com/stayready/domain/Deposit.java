package com.stayready.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import com.stayready.enums.Type;

@Entity
public class Deposit {

    @Id
    @GeneratedValue
    @Column(name = "DEPOSIT_ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TYPE")
    @NotEmpty
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "TRANSACTION_DATE")
    @NotEmpty
    private String transactionDate;

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Column(name = "STATUS")
    @NotEmpty
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "PAYEE_ID")
    @NotEmpty
    private Long payeeId;

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    @Column(name = "MEDIUM")
    @NotEmpty
    private String medium;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Column(name = "AMOUNT")
    @NotEmpty
    private Long amount;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "DESCRIPTION")
    @NotEmpty
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
