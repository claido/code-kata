package za.co.code.kata.client;

import za.co.code.kata.exception.InvalidInputException;
import za.co.code.kata.model.Address;
import za.co.code.kata.model.Type;
import za.co.code.kata.service.AddressService;
import za.co.code.kata.service.IAddressService;
import za.co.code.kata.utils.AddressUtils;

import java.util.Scanner;

import static za.co.code.kata.utils.Constants.ADDRESS_FILE_NAME;

public class AddressClient {

    private static IAddressService addressService = new AddressService();

    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Address Service");
        System.out.println("Select Operation : 1- Print all Addresses, 2 Print Address type, 3 - Validate all addresses");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                String printAllAddresses = addressService.printAllAddresses(ADDRESS_FILE_NAME);
                System.out.println(printAllAddresses);
                break;
            case 2:
                System.out.println("Select address type (1 - Physical, 2 Postal, 3 - Business):");
                Type type = new Type();
                String nextLine = scanner.nextLine();
                type.setCode(nextLine);
                String printAddressByType = addressService.printAddressByType(type, ADDRESS_FILE_NAME);
                System.out.println(printAddressByType);
                break;
            case 3:
                Address[] addresses = AddressUtils.readAddressesFromFile(ADDRESS_FILE_NAME);
                for (Address address : addresses) {
                    String validateAddress = addressService.validateAddress(address);
                    System.out.print(address + " ==" +  validateAddress);
                }
                break;
            default:
                throw new InvalidInputException("Invalid option selected");
        }
    }
}
