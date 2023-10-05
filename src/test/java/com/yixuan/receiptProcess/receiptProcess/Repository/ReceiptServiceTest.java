package com.yixuan.receiptProcess.receiptProcess.Repository;

import com.yixuan.receiptProcess.receiptProcess.Model.Item;
import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.Repository.ReceiptRepository;
import com.yixuan.receiptProcess.receiptProcess.Service.ReceiptService;
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
//    @Test
//    public void testSaveAndFindOneReceipts() {
//        Receipt receipt1 = createSampleReceipt();
//
//        // Mocking the repository interactions
//        when(receiptRepository.save(any(Receipt.class))).thenReturn(receipt1);
//        when(receiptRepository.findOne(receipt1.getId())).thenReturn(Optional.of(receipt1));
//
//        Receipt savedReceipt = receiptService.saveReceipt(receipt1); // Assuming you have a saveReceipt method in the service
//        HashMap<String, Integer> receiptPoints = receiptService.getReceiptPoints(receipt1.getId());
//
//        assertEquals(receipt1, savedReceipt);
//
//        // Verifying the interactions with the repository
//        verify(receiptRepository, times(1)).save(receipt1);
//        verify(receiptRepository, times(1)).findOne(receipt1.getId());
//    }

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
