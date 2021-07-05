package com.stayready.domain;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddressTest {
    Address address;

    @Before
    public void setup() throws Exception{
        this.address = new Address();
    }

    @Test
    public void getIdTest(){
        //Given

        //When

        //Then
        assertNull(address.getId());
    }

    @Test
    public void setIdTest() {
        //Given
        Long expected = 1L;

        //When
        address.setId(expected);
        Long actual = address.getId();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void getStreetNumberTest() {
        //Given

        //When

        //Then
        assertNull(address.getStreetNumber());
    }

    @Test
    public void setStreetNumberTest() {
        //Given
        String expected = "123";

        //When
        address.setStreetNumber(expected);
        String actual = address.getStreetNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void getStreetNameTest() {
        //Given

        //When

        //Then
        assertNull(address.getStreetName());
    }

    @Test
    public void setStreetNameTest() {
        //Given
        String expected = "Sesame Street";

        //When
        address.setStreetName(expected);
        String actual = address.getStreetName();

        assertEquals(expected, actual);
    }

    @Test
    public void getCityTest() {
        //Given

        //When

        //Then
        assertNull(address.getCity());
    }

    @Test
    public void setCityTest() {
        //Given
        String expected = "Wilmington";

        //When
        address.setCity(expected);
        String actual = address.getCity();

        assertEquals(expected, actual);
    }

    @Test
    public void getStateTest() {
        //Given

        //When

        //Then
        assertNull(address.getState());
    }

    @Test
    public void setStateTest() {
        //Given
        String expected = "Delaware";

        //When
        address.setState(expected);
        String actual = address.getState();

        assertEquals(expected, actual);
    }

    @Test
    public void getZipTest() {
        //Given

        //When

        //Then
        assertNull(address.getZip());
    }

    @Test
    public void setZipTest() {
        //Given
        String expected = "19801";

        //When
        address.setZip(expected);
        String actual = address.getZip();

        assertEquals(expected, actual);
    }
}