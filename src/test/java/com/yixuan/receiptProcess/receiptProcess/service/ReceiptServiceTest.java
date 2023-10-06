package com.yixuan.receiptProcess.receiptProcess.service;

import com.yixuan.receiptProcess.receiptProcess.model.Item;
import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.repository.ReceiptRepository;
import com.yixuan.receiptProcess.receiptProcess.service.accumulator.PointsAccumulatorService;
import com.yixuan.receiptProcess.receiptProcess.exception.ReceiptNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptServiceTest {

    @Mock
    private ReceiptRepository repository;

    @Mock
    private PointsAccumulatorService accumulator;

    @InjectMocks
    private ReceiptService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getReceiptPoints_WhenReceiptExists_ReturnsPoints() {
        UUID id = UUID.randomUUID();
        Receipt mockReceipt = createSampleReceipt();
        when(repository.findOne(id)).thenReturn(mockReceipt);
        when(accumulator.accumulate(mockReceipt)).thenReturn(100);

        var result = service.getReceiptPoints(id);

        assertEquals(100, result);
    }

    @Test
    void getReceiptPoints_WhenReceiptDoesNotExist_ThrowsException() {
        UUID id = UUID.randomUUID();
        when(repository.findOne(id)).thenReturn(null);

        Exception exception = assertThrows(ReceiptNotFoundException.class, () -> {
            service.getReceiptPoints(id);
        });

        assertTrue(exception.getMessage().contains("Receipt with id:" + id + "not found"));
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
