package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmountTotalIsaRoundDollarWithoutCentsPointsCalculatorTest {

    private AmountTotalIsaRoundDollarWithoutCentsPointsCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new AmountTotalIsaRoundDollarWithoutCentsPointsCalculator();
    }

    @Test
    public void testCalculateWithRoundDollarTotal() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 100.0);
        int points = calculator.calculate(receipt);
        assertEquals(50, points, "Should award 50 points for round dollar total");
    }

    @Test
    public void testCalculateWithCentsTotal() {
        Receipt receipt = new Receipt(null, "Sample", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 100.50);
        int points = calculator.calculate(receipt);
        assertEquals(0, points, "Should not award points for total with cents");
    }
}
