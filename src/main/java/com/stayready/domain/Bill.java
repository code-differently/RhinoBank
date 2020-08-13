package com.stayready.domain;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Bill {
    @Id
    @GeneratedValue
    @Column(name = "BILL_ID")
    private Long id;  //why don't we name this billId?

    @Column(name = "STATUS")
    private Status status;

    @Column(name = "PAYEE")
    private String payee;

    @Column(name = "BILL_NICKNAME")
    private String nickname;   //nickname for the bill

    @Column(name = "CREATION_DATE")
    private String creationDate;

    @Column(name = "PAYMENT_DATE")
    private String paymentDate;

    @Column(name = "RECURRING_DATE")
    private Integer recurringDate;

    @Column(name = "UPCOMING_PAYMENT_DATE")
    private String upcomingPaymentDate;

    @Column(name = "PAYMENT_AMOUNT")
    private Double paymentAmount;

    @Column(name = "ACCOUNT_ID")
    private String accountId;  //the Account the bill is associated with

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getRecurringDate() {
        return recurringDate;
    }

    public void setRecurringDate(Integer recurringDate) {
        this.recurringDate = recurringDate;
    }

    public String getUpcomingPaymentDate() {
        return upcomingPaymentDate;
    }

    public void setUpcomingPaymentDate(String upcomingPaymentDate) {
        this.upcomingPaymentDate = upcomingPaymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }



}
