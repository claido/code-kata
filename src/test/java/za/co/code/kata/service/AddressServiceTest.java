package za.co.code.kata.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.code.kata.model.Address;
import za.co.code.kata.utils.AddressUtils;

public class AddressServiceTest {

    private IAddressService iAddressService;

    private Address[] addresses = null;

    @Before
    public void setUp() throws Exception {
        iAddressService = new AddressService();
        addresses = AddressUtils.readAddressesFromFile("src/test/resources/addresses.json");
    }

    @Test
    public void testPrettyPrintAddress() {
        String prettyPrintAddress = iAddressService.prettyPrintAddress(addresses[0]);
        Assert.assertNotNull(prettyPrintAddress);
        Assert.assertEquals("Address Detail (Type: Code (1) Name (Physical Address), Line details : Line 1 (Address 1) Line 2Line 2), City : (City 1), Province/State: Code(5) Name (Eastern Cape), Postal Code : (1234) Country : Code (ZA)  Name (South Africa)",prettyPrintAddress);
    }

    @Test
    public void testPrintAddressByTpe() {
        String addressByType = iAddressService.printAddressByType(addresses[0].getType(), "src/test/resources/addresses.json");
        Assert.assertNotNull(addressByType);
        Assert.assertEquals("Address Detail (Type: Code (1) Name (Physical Address), Line details : Line 1 (Address 1) Line 2Line 2), City : (City 1), Province/State: Code(5) Name (Eastern Cape), Postal Code : (1234) Country : Code (ZA)  Name (South Africa)",addressByType);
    }

    @Test
    public void testValidateAddressNonNumericPC() {
        Address address = addresses[0];
        address.setPostalCode("nonNumeric");
        String validateAddress = iAddressService.validateAddress(address);
        Assert.assertNotNull(validateAddress);
        Assert.assertEquals("The postal code must be numeric\n",validateAddress);
    }

    @Test
    public void testValidateAddressNoProvinceNonNumeric() {
        Address address = addresses[2];
        address.setPostalCode("nonNumeric");
        String validateAddress = iAddressService.validateAddress(address);
        Assert.assertNotNull(validateAddress);
        Assert.assertEquals("The postal code must be numeric\n" +
                "Province must not be null\n" +
                "At least one address line must be provided.\n",validateAddress);
    }

    @Test
    public void testPrintAllAddresses() {
        String printAllAddresses = iAddressService.printAllAddresses("src/test/resources/addresses.json");
        Assert.assertNotNull(printAllAddresses);
    }
}