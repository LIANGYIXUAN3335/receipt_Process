package com.yixuan.receiptProcess.receiptProcess.repository;

import com.yixuan.receiptProcess.receiptProcess.model.Item;
import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.service.ReceiptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReceiptServiceTest {

    @InjectMocks
    private ReceiptService receiptService;

    @Mock
    private ReceiptRepository receiptRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllReceipts() {
        Receipt receipt1 = createSampleReceipt();
        Receipt receipt2 = createSampleReceipt();

        when(receiptRepository.findAll()).thenReturn(Arrays.asList(receipt1, receipt2));

        List<Receipt> receipts = receiptService.findAllReceipts();

        assertEquals(2, receipts.size());
        verify(receiptRepository, times(1)).findAll();
    }

    @Test
    public void testSaveAndFindOneReceipts() {
        Receipt receipt1 = createSampleReceipt();

        // Mocking the repository interactions
        when(receiptRepository.save(any(Receipt.class))).thenReturn(receipt1);
        when(receiptRepository.findOne(receipt1.getId())).thenReturn(receipt1);  // <-- Direct Receipt object

        Receipt savedReceipt = receiptService.saveReceipt(receipt1);
//        int receiptPoints = receiptService.getReceiptPoints(receipt1.getId());

        assertEquals(receipt1, savedReceipt);

        // You might want to add an assertion for receiptPoints here if you know the expected value.

        // Verifying the interactions with the repository
        verify(receiptRepository, times(1)).save(receipt1);
        verify(receiptRepository, times(1)).findOne(receipt1.getId());
    }


    // You can add more test methods here for other functionalities of ReceiptService

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
