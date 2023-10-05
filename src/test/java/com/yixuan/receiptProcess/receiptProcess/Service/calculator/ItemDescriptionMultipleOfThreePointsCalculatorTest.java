package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Item;
import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemDescriptionMultipleOfThreePointsCalculatorTest {

    private ItemDescriptionMultipleOfThreePointsCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new ItemDescriptionMultipleOfThreePointsCalculator();
    }

    @Test
    public void testCalculateWithDescriptionLengthMultipleOfThree() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.now(),
                Arrays.asList(new Item("abc", 10.0), new Item("abcdef", 10.0)),
                20.0);
        int points = calculator.calculate(receipt);
        assertEquals(4, points, "Should award 4 points for descriptions of lengths 3 and 6 with item prices of 10 each");
    }

    @Test
    public void testCalculateWithoutDescriptionLengthMultipleOfThree() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.now(),
                Arrays.asList(new Item("abcd", 10.0), new Item("abcde", 10.0)),
                20.0);
        int points = calculator.calculate(receipt);
        assertEquals(0, points, "Should not award any points if no description length is a multiple of three");
    }

    @Test
    public void testCalculateMixedItems() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.now(),
                Arrays.asList(new Item("abc", 10.0), new Item("abcde", 10.0)),
                20.0);
        int points = calculator.calculate(receipt);
        assertEquals(2, points, "Should award 2 points for one description of length 3 with item price of 10");
    }
}
