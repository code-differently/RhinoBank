package com.stayready.domain;

import com.stayready.enums.Type;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    private Account account;

    @Before
    public void setup() {
        account = new Account();
    }

    @Test
    public void getIdTest() {
        assertNull(account.getId());
    }

    @Test
    public void setIdTest() {
        Long expectedId = 5L;

        account.setId(5L);
        Long actualId = account.getId();

        assertEquals(expectedId, actualId);
    }

    @Test
    public void getTypeTest() {
        assertNull(account.getType());
    }

    @Test
    public void setTypeTest() {
        String expected = "credit";

        account.setType(Type.CREDIT.getAccountType());
        String actual = account.getType();

        assertEquals(expected, actual);
    }

    @Test
    public void getNicknameTest() {
        assertNull(account.getNickname());
    }

    @Test
    public void setNicknameTest() {
        String expected = "Paul";

        account.setNickname(expected);
        String actual = account.getNickname();

        assertEquals(expected, actual);
    }

    @Test
    public void getRewardsTest() {
        int expected = 0;

        int actual = account.getRewards();

        assertEquals(expected, actual);
    }

    @Test
    public void setRewardsTest() {
        int expected = 0;

        account.setRewards(expected);
        int actual = account.getRewards();

        assertEquals(expected, actual);
    }

    @Test
    public void getCustomerTest() {
        assertNull(account.getCustomerId());
    }

    @Test
    public void setCustomerTest() {
        Long expected = 4L;

        account.setCustomerId(expected);
        Long actual = account.getCustomerId();

        assertEquals(expected, actual);
    }
}
