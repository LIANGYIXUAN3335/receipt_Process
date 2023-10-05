package com.yixuan.receiptProcess.receiptProcess.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.Service.ReceiptService;
import com.yixuan.receiptProcess.receiptProcess.Repository.ReceiptRepository;
import com.yixuan.receiptProcess.receiptProcess.Service.accumulator.PointsAccumulatorService;
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

    @MockBean
    private ReceiptRepository repository;

    @MockBean
    private PointsAccumulatorService accumulator;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void testRetrieveAllReceipts() throws Exception {
        UUID id = UUID.randomUUID();
        Receipt receipt = new Receipt(id, "Sample", LocalDate.now(), LocalTime.now(), Collections.emptyList(), 10.0);

        when(repository.findAll()).thenReturn(Collections.singletonList(receipt));

        mockMvc.perform(get("/receipts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
