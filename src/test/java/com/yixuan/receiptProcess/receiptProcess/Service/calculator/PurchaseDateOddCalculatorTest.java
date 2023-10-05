package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseDateOddCalculatorTest {

    private PurchaseDateOddCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new PurchaseDateOddCalculator();
    }

    @Test
    public void testCalculateWithOddDayOfMonth() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.of(2023, 10, 3), LocalTime.now(), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(6, points, "Should award 6 points for odd day of month");
    }

    @Test
    public void testCalculateWithEvenDayOfMonth() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.of(2023, 10, 4), LocalTime.now(), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(0, points, "Should not award any points for even day of month");
    }
}
