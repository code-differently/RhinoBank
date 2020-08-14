package com.stayready.domain;

import com.stayready.enums.Medium;
import com.stayready.enums.Type;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DepositTest {
    Deposit deposit;

    @Before
    public void setup() throws Exception{
        this.deposit = new Deposit();
    }

    @Test
    public void getIdTest(){
        //Given

        //When

        //Then
        assertNull(deposit.getId());
    }

    @Test
    public void setIdTest() {
        //Given
        Long expected = 1L;

        //When
        deposit.setId(expected);
        Long actual = deposit.getId();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        //Given

        //When

        //Then
        assertNull(deposit.getType());
    }

    @Test
    public void setTypeTest() {
        //Given
        String expected = "savings";

        //When
        deposit.setType(Type.SAVINGS.getAccountType());
        String actual = deposit.getType();

        assertEquals(expected, actual);
    }

    @Test
    public void getTransactionDateTest() {
        //Given

        //When

        //Then
        assertNull(deposit.getTransactionDate());
    }

    @Test
    public void setTransactionDateTest() {
        //Given
        String expected = "1-11-2020";

        //When
        deposit.setTransactionDate(expected);
        String actual = deposit.getTransactionDate();

        assertEquals(expected, actual);
    }

    @Test
    public void getStatusTest() {
        //Given

        //When

        //Then
        assertNull(deposit.getStatus());
    }

    @Test
    public void setStatusTest() {
        //Given
        String expected = "Completed";

        //When
        deposit.setStatus(expected);
        String actual = deposit.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void getPayeeIdTest() {
        //Given

        //When

        //Then
        assertNull(deposit.getPayeeId());
    }

    @Test
    public void setPayeeIdTest() {
        //Given
        Long expected = 2L;

        //When
        deposit.setPayeeId(expected);
        Long actual = deposit.getPayeeId();

        assertEquals(expected, actual);
    }

    @Test
    public void getMediumTest() {
        //Given

        //When

        //Then
        assertNull(deposit.getMedium());
    }

    @Test
    public void setMediumTest() {
        //Given
        String expected = "rewards";

        //When
        deposit.setType(Medium.REWARDS.getMedium());
        String actual = deposit.getType();

        assertEquals(expected, actual);
    }

    @Test
    public void getAmountTest() {
        //Given

        //When

        //Then
        assertNull(deposit.getAmount());
    }

    @Test
    public void setAmountTest() {
        //Given
        Long expected = 150L;

        //When
        deposit.setAmount(expected);
        Long actual = deposit.getAmount();

        assertEquals(expected, actual);
    }

    @Test
    public void getDescriptionTest() {
        //Given

        //When

        //Then
        assertNull(deposit.getDescription());
    }

    @Test
    public void setDescriptionTest() {
        //Given
        String expected = "cash bonus";

        //When
        deposit.setDescription(expected);
        String actual = deposit.getDescription();

        assertEquals(expected, actual);
    }
}