package com.yixuan.receiptProcess.receiptProcess.service.calculator;

import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseTimeFromTwoToFourCalculatorTest {

    private PurchaseTimeFromTwoToFourCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new PurchaseTimeFromTwoToFourCalculator();
    }

    @Test
    public void testCalculatePurchaseTimeAt2PM() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.of(14, 0), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(10, points, "Should award 10 points for purchase at 2 PM");
    }

    @Test
    public void testCalculatePurchaseTimeAt3PM() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.of(15, 0), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(10, points, "Should award 10 points for purchase at 3 PM");
    }

    @Test
    public void testCalculatePurchaseTimeAt4PM() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.of(16, 0), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(10, points, "Should award 10 points for purchase at 4 PM");
    }

    @Test
    public void testCalculatePurchaseTimeAfter4PM() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.of(16, 1), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(0, points, "Should not award any points for purchase after 4 PM");
    }

    @Test
    public void testCalculatePurchaseTimeBefore2PM() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.of(13, 59), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(0, points, "Should not award any points for purchase before 2 PM");
    }
}
