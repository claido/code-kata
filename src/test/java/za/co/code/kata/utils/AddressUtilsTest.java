package za.co.code.kata.utils;

import org.junit.Assert;
import org.junit.Test;
import za.co.code.kata.model.Address;

public class AddressUtilsTest {

    @Test
    public void testReadAddressesFromFile() {
        Address[] addresses = AddressUtils.readAddressesFromFile("src/test/resources/addresses.json");
        Assert.assertEquals(3,addresses.length);
    }

    @Test
    public void testReadAddressesFromFileIncorrectFileName() {
        Address[] addresses = AddressUtils.readAddressesFromFile("src/test/resources/addressessss.json");
        Assert.assertNull(addresses);
    }
}