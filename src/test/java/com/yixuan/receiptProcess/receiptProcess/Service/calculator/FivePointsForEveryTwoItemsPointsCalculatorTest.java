package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Item;
import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FivePointsForEveryTwoItemsPointsCalculatorTest {

    private FivePointsForEveryTwoItemsPointsCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new FivePointsForEveryTwoItemsPointsCalculator();
    }

    @Test
    public void testCalculateWithTwoItems() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.now(),
                Arrays.asList(new Item("item1", 10.0), new Item("item2", 10.0)),
                20.0);
        int points = calculator.calculate(receipt);
        assertEquals(5, points, "Should award 5 points for 2 items");
    }

    @Test
    public void testCalculateWithThreeItems() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.now(),
                Arrays.asList(new Item("item1", 10.0), new Item("item2", 10.0), new Item("item3", 10.0)),
                30.0);
        int points = calculator.calculate(receipt);
        assertEquals(5, points, "Should award 5 points for 3 items");
    }

    @Test
    public void testCalculateWithFourItems() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.now(),
                Arrays.asList(new Item("item1", 10.0), new Item("item2", 10.0), new Item("item3", 10.0), new Item("item4", 10.0)),
                40.0);
        int points = calculator.calculate(receipt);
        assertEquals(10, points, "Should award 10 points for 4 items");
    }

    @Test
    public void testCalculateWithNoItems() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(0, points, "Should not award any points if there are no items");
    }
}

