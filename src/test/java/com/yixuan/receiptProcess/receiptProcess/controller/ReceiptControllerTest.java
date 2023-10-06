package com.yixuan.receiptProcess.receiptProcess.controller;

import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.service.ReceiptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReceiptController.class)
public class ReceiptControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReceiptService service;

    private UUID id;
    private Receipt receipt;

    @BeforeEach
    public void setup() {
        id = UUID.randomUUID();
        receipt = new Receipt(id, "Sample", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 10.0);
    }

    @Test
    public void testRetrieveAllReceipts() throws Exception {
        when(service.findAllReceipts()).thenReturn(Collections.singletonList(receipt));

        mockMvc.perform(get("/receipts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetReceiptPoints() throws Exception {
        when(service.getReceiptPoints(id)).thenReturn(100); // Assuming 100 points for the given receipt.

        mockMvc.perform(get("/receipts/" + id + "/points")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // Add more tests for other endpoints like createReceipt, etc.
}
