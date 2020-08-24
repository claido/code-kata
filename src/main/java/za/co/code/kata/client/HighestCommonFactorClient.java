package za.co.code.kata.client;

import za.co.code.kata.exception.InvalidInputException;
import za.co.code.kata.service.HighestCommonFactorService;
import za.co.code.kata.service.IHighestCommonFactorService;

import java.util.logging.Logger;

public class HighestCommonFactorClient {

    private static final Logger LOGGER = Logger.getLogger(HighestCommonFactorClient.class.getName());

    private static IHighestCommonFactorService highestCommonFactorService = new HighestCommonFactorService();

    public static void main(String[] args) throws InvalidInputException {

        int length = args.length;
        int numbers[] = new int[length];

        for (int i = 0; i < length; i++)
            numbers[i] = Integer.parseInt(args[i]);

        int highestCommonFactor = highestCommonFactorService.highestCommonFactor(numbers);

        LOGGER.info("The Highest common factor is :: " + highestCommonFactor);

    }
}
