package za.co.code.kata.service;

import org.apache.commons.lang3.StringUtils;
import za.co.code.kata.model.*;
import za.co.code.kata.utils.AddressUtils;
import za.co.code.kata.utils.Constants;

public class AddressService implements IAddressService {

    @Override
    public String prettyPrintAddress(Address address) {

        StringBuilder stringBuilder = new StringBuilder();

        final Type addressType = address.getType();
        final AddressLineDetail addressLineDetail = address.getAddressLineDetail();
        final Country country = address.getCountry();
        final ProvinceOrState provinceOrState = address.getProvinceOrState();

        stringBuilder.append("Address Detail (Type: Code (")
                .append(addressType.getCode())
                .append(") Name (")
                .append(addressType.getName())
                .append("), Line details : Line 1 (")
                .append(addressLineDetail.getLine1());

        if (addressLineDetail.getLine2() != null && !addressLineDetail.getLine2().trim().isEmpty()) {
            stringBuilder.append(") Line 2").append(addressLineDetail.getLine2());
        }

        stringBuilder.append("), City : (")
                .append(address.getCityOrTown())
                .append("), Province/State: Code(")
                .append(provinceOrState.getCode())
                .append(") Name (")
                .append(provinceOrState.getName())
                .append("), Postal Code : (")
                .append(address.getPostalCode())
                .append(") Country : Code (")
                .append(country.getCode())
                .append(")  Name (")
                .append(country.getName())
                .append(")");
        return stringBuilder.toString();
    }

    @Override
    public String printAddressByType(Type type) {
        for (Address address : AddressUtils.readAddressesFromFile(Constants.ADDRESS_FILE_NAME)) {
            if (address.getType().getCode().equalsIgnoreCase(type.getCode()))
                return prettyPrintAddress(address);
        }
        return null;
    }

    @Override
    public String validateAddress(Address address) {

        StringBuilder stringBuilder = new StringBuilder();
        if (!StringUtils.isNumeric(address.getPostalCode())) {
            stringBuilder.append("The postal code must be numeric");
            stringBuilder.append("\n");
        }

        if (address.getCountry() == null)
            stringBuilder.append("The country must not be null\n");
        else {
            if (address.getCountry().getCode().equals("ZA")) {
                if (address.getProvinceOrState() == null)
                    stringBuilder.append("Province must not be null\n");

            }
        }
        AddressLineDetail addressLineDetail = address.getAddressLineDetail();
        if (addressLineDetail == null || StringUtils.isBlank(addressLineDetail.getLine1())
                || StringUtils.isBlank(addressLineDetail.getLine2())) {
            stringBuilder.append("At least one address line must be provided.\n");
        }

        return stringBuilder.toString();
    }
}
