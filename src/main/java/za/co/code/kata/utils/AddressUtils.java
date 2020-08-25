package za.co.code.kata.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import za.co.code.kata.model.Address;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddressUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger LOGGER = Logger.getLogger(AddressUtils.class.getName());

    static {

        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    public static Address[] readAddressesFromFile(String filename) {
        Address[] addresses = null;
        try {
            addresses = objectMapper.readValue(new File(filename), Address[].class);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to read the json address", e);
        }
        return addresses;
    }

}
