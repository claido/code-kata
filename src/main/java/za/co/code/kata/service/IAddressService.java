package za.co.code.kata.service;

import za.co.code.kata.model.Address;
import za.co.code.kata.model.Type;

public interface IAddressService {

    String prettyPrintAddress(Address address);

    String printAddressByType(Type type,String filename);

    String validateAddress(Address address);

    String printAllAddresses(String filename);
}
