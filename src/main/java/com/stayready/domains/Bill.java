package com.stayready.domains;

import com.stayready.enums.BillStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bill {
    @Id
    @GeneratedValue
    @Column(name = "BILL_ID")
    private long id;

    @Column
    private BillStatus status;

    @Column
    private String payee;

    @Column
    private String nickname;

    @Column
    private String creation_Date;

    @Column
    private String payment_Date;

    @Column
    private int recurring_Date;

    @Column
    private String upcoming_Payment_Date;

    @Column
    private double payment_Amount;

    @Column
    private String account_Id;

    public long getId() {
        return id;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
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

    public String getCreation_Date() {
        return creation_Date;
    }

    public void setCreation_Date(String creation_Date) {
        this.creation_Date = creation_Date;
    }

    public String getPayment_Date() {
        return payment_Date;
    }

    public void setPayment_Date(String payment_Date) {
        this.payment_Date = payment_Date;
    }

    public int getRecurring_Date() {
        return recurring_Date;
    }

    public void setRecurring_Date(int recurring_Date) {
        this.recurring_Date = recurring_Date;
    }

    public String getUpcoming_Payment_Date() {
        return upcoming_Payment_Date;
    }

    public void setUpcoming_Payment_Date(String upcoming_Payment_Date) {
        this.upcoming_Payment_Date = upcoming_Payment_Date;
    }

    public double getPayment_Amount() {
        return payment_Amount;
    }

    public void setPayment_Amount(double payment_Amount) {
        this.payment_Amount = payment_Amount;
    }

    public String getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(String account_Id) {
        this.account_Id = account_Id;
    }
}
