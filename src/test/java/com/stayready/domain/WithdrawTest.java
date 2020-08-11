package com.stayready.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WithdrawTest {

    Withdraw w;
    @Before
    public void initialize(){
        w = new Withdraw();
    }

    @Test
    public void getIdTest() {

        Assert.assertEquals(null, w.getId());
    }

    @Test
    public void setIdTest() {
        Long exp = 10L;
        w.setId(10L);
        Assert.assertEquals(exp, w.getId());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(null, w.getType());
    }

    @Test
    public void setTypeTest() {
       /* TransactionType type = TransactionType.DEPOSIT;
        w.setType(type.getTransactionType());
        Assert.assertEquals(type.getTransactionType(), w.getType()); */
    }

    @Test
    public void getTransactionDateTest() {
        Assert.assertEquals(null, w.getTransactionDate());
    }

    @Test
    public void setTransactionDateTest() {
    }

    @Test
    public void getStatusTest() {
        Assert.assertEquals(null, w.getStatus());
    }

    @Test
    public void setStatusTest() {
    }

    @Test
    public void getPayeeIdTest() {
        Assert.assertEquals(null, w.getPayeeId());
    }

    @Test
    public void setPayeeIdTest() {
        Long exp = 10L;
        w.setPayeeId(10L);
        Assert.assertEquals(exp, w.getPayeeId());
    }

    @Test
    public void getMediumTest() {
        Assert.assertEquals(null, w.getMedium());
    }

    @Test
    public void setMediumTest() {
    }

    @Test
    public void getAmountTest() {
        Assert.assertEquals(.1,0.0, w.getAmount());
    }

    @Test
    public void setAmountTest() {

        w.setAmount(10.00);
        Assert.assertEquals(.1,10.0, w.getAmount());
    }

    @Test
    public void getDescriptionTest() {
        Assert.assertEquals(null, w.getDescription());
    }

    @Test
    public void setDescriptionTest() {
        w.setDescription("Get the money");
        Assert.assertEquals("Get the money", w.getDescription());
    }
}