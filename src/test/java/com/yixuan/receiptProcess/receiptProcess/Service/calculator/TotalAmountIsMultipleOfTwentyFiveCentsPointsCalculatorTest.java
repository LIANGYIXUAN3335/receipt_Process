package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalAmountIsMultipleOfTwentyFiveCentsPointsCalculatorTest {

    private TotalAmountIsMultipleOfTwentyFiveCentsPointsCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new TotalAmountIsMultipleOfTwentyFiveCentsPointsCalculator();
    }

    @Test
    public void testCalculateReceiptTotalIsMultipleOfTwentyFiveCents() {
        Receipt receipt = new Receipt(null, "Retailer", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 1.25);
        int points = calculator.calculate(receipt);
        assertEquals(25, points, "Should award 25 points if the total is a multiple of $0.25.");
    }

    @Test
    public void testCalculateReceiptTotalIsNotMultipleOfTwentyFiveCents() {
        Receipt receipt = new Receipt(null, "Retailer", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 1.23);
        int points = calculator.calculate(receipt);
        assertEquals(0, points, "Should award no points if the total is not a multiple of $0.25.");
    }

    @Test
    public void testCalculateReceiptTotalIsZero() {
        Receipt receipt = new Receipt(null, "Retailer", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(25, points, "Should award 25 points if the total is zero, since it's also a multiple of $0.25.");
    }
}
