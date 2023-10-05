package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RetailerNameAlphanumericCharacterPointsCalculatorTest {

    private RetailerNameAlphanumericCharacterPointsCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new RetailerNameAlphanumericCharacterPointsCalculator();
    }

    @Test
    public void testCalculateRetailerNameWithAlphanumericCharacters() {
        Receipt receipt = new Receipt(null, "Tesco123", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(8, points, "Should award 8 points for 8 alphanumeric characters in the retailer name.");
    }

    @Test
    public void testCalculateRetailerNameWithSpecialCharacters() {
        Receipt receipt = new Receipt(null, "T@sc0*!", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(5, points, "Should award 5 points for 5 alphanumeric characters, excluding special characters.");
    }

    @Test
    public void testCalculateEmptyRetailerName() {
        Receipt receipt = new Receipt(null, "", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(0, points, "Should award no points for an empty retailer name.");
    }

    @Test
    public void testCalculateRetailerNameWithSpaces() {
        Receipt receipt = new Receipt(null, "Test Store", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 0.0);
        int points = calculator.calculate(receipt);
        assertEquals(9, points, "Should award 9 points for 9 alphanumeric characters, excluding spaces.");
    }
}
