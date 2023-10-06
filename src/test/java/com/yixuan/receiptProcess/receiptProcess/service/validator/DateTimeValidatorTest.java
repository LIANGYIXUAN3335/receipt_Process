package com.yixuan.receiptProcess.receiptProcess.service.validator;

import com.yixuan.receiptProcess.receiptProcess.model.Item;
import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateTimeValidatorTest {

    private DateTimeValidator validator;  //
    @Mock
    private ConstraintValidatorContext context;
    @Mock
    private ConstraintValidatorContext.ConstraintViolationBuilder violationBuilder;  //

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        validator = new DateTimeValidator();

        Mockito.when(context.buildConstraintViolationWithTemplate(Mockito.anyString()))
                .thenReturn(violationBuilder);  //
        Mockito.when(context.buildConstraintViolationWithTemplate(Mockito.anyString()))
                .thenReturn(violationBuilder);

    }


    @Test
    public void testIsValidReceiptIsNull() {
        Receipt receipt = null;
        assertTrue(validator.isValid(receipt, context), "Should return true if receipt is null");  // 你的验证器对于null的Receipt返回true，所以这里应该断言为true
    }

    @Test
    public void testIsValidPurchaseTimeNotInFuture() {
        Receipt receipt = createSampleReceipt();
        receipt.setPurchaseDate(LocalDate.now());
        receipt.setPurchaseTime(LocalTime.now().minusHours(1));

        assertTrue(validator.isValid(receipt, context), "Should return true if purchaseTime is not in the future for today's date");
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
