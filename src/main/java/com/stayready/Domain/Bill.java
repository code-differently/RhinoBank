package com.stayready.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bill{

    @Id
    @GeneratedValue
    @Column(name = "BILL_ID")
    private Long id; 

    @Column(name = "BILL_STATUS")
    private String status;

    @Column(name = "BILL_PAYEE")
    private String payee;

    @Column(name = "BILL_NICKNAME")
    private String nickname;

    @Column(name = "BILL_CREATION_DATE")
    private String creation_date;

    @Column(name = "BILL_PAYMENT_DATE")
    private String payment_date;

    @Column(name = "BILL_RECURRING_DATE")
    private Integer recurring_date;

    @Column(name = "BILL_UPCOMING_PAYMENT_DATE")
    private String upcoming_payment_date;

    @Column(name = "BILL_PAYMENT_AMOUNT")
    private Double payment_amount;

    @Column(name = "ACCOUNT_ID")
    private String account_id;

    public void setId(Long id){
        this.id = id;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setPayee(String payee){
        this.payee = payee;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public void setCreationDate(String creation_date){
        this.creation_date = creation_date;
    }

    public void setPaymentDate(String payment_date){
        this.payment_date = payment_date;
    }

    public void setRecurringDate(Integer recurring_date){
        this.recurring_date = recurring_date;
    }

    public void setUpcomingPaymentDate(String upcoming_payment_date){
        this.upcoming_payment_date = upcoming_payment_date;
    }

    public void setPaymentAmount(Double payment_amount){
        this.payment_amount = payment_amount;
    }

    public void setId(String account_id){
        this.account_id = account_id;
    }

    public String getStatus(){
        return status;
    }

    public String getPayee(){
        return payee;
    }

    public String getNickname(){
        return nickname;
    }

    public String getCreationDate(){
        return creation_date;
    }

    public String getPaymentDate(){
        return payment_date;
    }

    public Integer getRecurringDate(){
        return recurring_date;
    }

    public String getUpcomingPaymentDate(){
        return upcoming_payment_date;
    }

    public Double getPaymentAmount(){
        return payment_amount;
    }

    public String getId(){
        return account_id;
    }
}
  
  
  
  