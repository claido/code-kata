package za.co.code.kata.service;

import za.co.code.kata.exception.InvalidInputException;

public interface IHighestCommonFactorService {

    int highestCommonFactor(int[] numbers) throws InvalidInputException;
}
