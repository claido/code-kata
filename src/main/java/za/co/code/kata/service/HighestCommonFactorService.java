package za.co.code.kata.service;

import za.co.code.kata.exception.InvalidInputException;

import java.util.logging.Logger;

public class HighestCommonFactorService implements IHighestCommonFactorService {

    private static final Logger LOGGER = Logger.getLogger(HighestCommonFactorService.class.getName());


    /**
     * This function takes in an array of integers and calculate the highest common factor.
     *
     * @param numbers
     * @return highest common factor
     * @throws InvalidInputException
     */
    public int highestCommonFactor(int[] numbers) throws InvalidInputException {

        final int totalElements = numbers.length;
        if (totalElements < 2)
            throw new InvalidInputException("The array must contain at least 2 elements");
        LOGGER.info("total elements in the array :: " + totalElements);

        final long startTime = System.currentTimeMillis();
        try {
            int highestCommonFactor = numbers[0];

            for (int i = 1; i < highestCommonFactor; i++) {
                calculateHCF(numbers[1], highestCommonFactor);
            }

            return highestCommonFactor;

        } finally {
            LOGGER.info("elapsed time " + (System.currentTimeMillis() - startTime) + " milliseconds");
        }
    }

    /**
     * @param number1
     * @param number2
     * @returns highest common factor between two numbers
     */
    public int calculateHCF(int number1, int number2) {
        LOGGER.info("Calculating highest common factor between" + number1 + " and " + number2);
        return number1 == 0 ? number2 : calculateHCF(number2 % number1, number1);
    }
}

interface IHighestCommonFactorService {

    int highestCommonFactor(int[] numbers) throws InvalidInputException;
}