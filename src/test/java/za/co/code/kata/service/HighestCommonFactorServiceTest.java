package za.co.code.kata.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.code.kata.exception.InvalidInputException;

public class HighestCommonFactorServiceTest {

    private IHighestCommonFactorService commonFactorService;

    @Before
    public void setup() {
        commonFactorService = new HighestCommonFactorService();
    }

    @Test
    public void highestCommonFactor() throws InvalidInputException {
        int []numbers = {16,4,2,8};
        int highestCommonFactor = commonFactorService.highestCommonFactor(numbers);
        Assert.assertEquals(2, highestCommonFactor);
    }

    @Test(expected = InvalidInputException.class)
    public void highestCommonFactorBetweenLessThan2Numbers() throws InvalidInputException {
        int[] numbers = {5};
        commonFactorService.highestCommonFactor(numbers);
    }

    @Test
    public void calculateHCF() {

        int expected = 5;
        HighestCommonFactorService highestCommonFactorService = new HighestCommonFactorService();
        int hcf = highestCommonFactorService.calculateHCF(10, 15);
        Assert.assertEquals(expected,hcf);
    }
}