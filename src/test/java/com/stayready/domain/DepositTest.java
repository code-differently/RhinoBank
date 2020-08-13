package com.stayready.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepositTest {

    Deposit d;
    @Before
    public void initialize(){
        d = new Deposit();
    }

    @Test
    public void getIdTest() {

        Assert.assertEquals(null, d.getId());
    }

    @Test
    public void setIdTest() {
        Long exp = 10L;
        d.setId(10L);
        Assert.assertEquals(exp, d.getId());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(null, d.getType());
    }

    @Test
    public void setTypeTest() {

    }

    @Test
    public void getTransactionDateTest() {
        Assert.assertEquals(null, d.getTransactionDate());
    }

    @Test
    public void setTransactionDateTest() {
        String exp = "1/2/2020";
        d.setTransactionDate(exp);
        Assert.assertEquals(exp, d.getTransactionDate());
    }

    @Test
    public void getStatusTest() {
        Assert.assertEquals(null, d.getStatus());
    }

    @Test
    public void setStatusTest() {
    }

    @Test
    public void getPayeeIdTest() {
        Assert.assertEquals(null, d.getPayeeId());
    }

    @Test
    public void setPayeeIdTest() {
        Long exp = 10L;
        d.setPayeeId(10L);
        Assert.assertEquals(exp, d.getPayeeId());
    }

    @Test
    public void getMediumTest() {
        Assert.assertEquals(null, d.getMedium());
    }

    @Test
    public void setMediumTest() {
    }

    @Test
    public void getAmountTest() {
        Assert.assertEquals(null, d.getAmount());
    }

    @Test
    public void setAmountTest() {
        d.setAmount(10.00);
        Assert.assertEquals(.1,10.0, d.getAmount());
    }

    @Test
    public void getDescriptionTest() {
        Assert.assertEquals(null, d.getDescription());
    }

    @Test
    public void setDescriptionTest() {
        d.setDescription("Taking the money");
        Assert.assertEquals("Taking the money", d.getDescription());
    }
}