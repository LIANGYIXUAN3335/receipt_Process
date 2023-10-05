package com.yixuan.receiptProcess.receiptProcess.Service.validator;

import com.yixuan.receiptProcess.receiptProcess.Model.Item;
import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.Service.Validator.DateTimeValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateTimeValidatorTest {

    @Mock
    private DateTimeValidator validator;
    @Mock
    private ConstraintValidatorContext context;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(context.buildConstraintViolationWithTemplate(Mockito.anyString())).thenReturn(Mockito.mock(ConstraintValidatorContext.ConstraintViolationBuilder.class));
    }

    @Test
    public void testIsValidReceiptIsNull() {
        Receipt receipt = null;
        assertFalse(validator.isValid(receipt, context), "Should return false if receipt is null");
    }

    @Test
    public void testIsValidPurchaseTimeInFuture() {
        Receipt receipt = createSampleReceipt();
        receipt.setPurchaseDate(LocalDate.now());
        receipt.setPurchaseTime(LocalTime.now().plusHours(1));

        assertFalse(validator.isValid(receipt, null), "Should return false if purchaseTime is in the future for today's date");
    }

    @Test
    public void testIsValidPurchaseTimeNotInFuture() {
        Receipt receipt = createSampleReceipt();
        receipt.setPurchaseDate(LocalDate.now());
        receipt.setPurchaseTime(LocalTime.now().minusHours(1));

        assertTrue(validator.isValid(receipt, null), "Should return true if purchaseTime is not in the future for today's date");
    }
    private Receipt createSampleReceipt() {
        UUID id = UUID.randomUUID();
        String retailer = "Walmart";
        LocalDate purchaseDate = LocalDate.now();
        LocalTime purchaseTime = LocalTime.now();
        List<Item> items = Arrays.asList(new Item("Apple", 0.99), new Item("Orange", 0.79));
        double total = 2.57;

        return new Receipt(id, retailer, purchaseDate, purchaseTime, items, total);
    }

}
