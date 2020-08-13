package com.stayready.enums;

import com.stayready.domain.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TypeTest {

    @Test
    public void getAccountTypeTest() {
        String expected = "savings";

        String actual = Type.SAVINGS.getAccountType();

        assertEquals(expected, actual);
    }
}
