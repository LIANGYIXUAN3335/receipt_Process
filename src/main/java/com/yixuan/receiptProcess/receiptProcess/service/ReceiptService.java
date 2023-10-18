package com.yixuan.receiptProcess.receiptProcess.service;

import com.yixuan.receiptProcess.receiptProcess.exception.ReceiptNotFoundException;
import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.repository.ReceiptRepository;
import com.yixuan.receiptProcess.receiptProcess.service.accumulator.PointsAccumulatorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReceiptService {

    private final ReceiptRepository repository;
    private final PointsAccumulatorService accumulator;

    public ReceiptService(ReceiptRepository receiptRepository,PointsAccumulatorService accumulator) {
        this.accumulator = accumulator;
        this.repository = receiptRepository;
    }
    public int getReceiptPoints(UUID id) {
        Receipt receipt = findReceiptById(id);
        if (receipt == null) {
<<<<<<< HEAD
<<<<<<< HEAD
            throw new ReceiptNotFoundException("Receipt with id:" + id +" not found");
=======
            throw new ReceiptNotFoundException("Receipt with id:" + id +"not found");
>>>>>>> parent of 1e12e71 (Update ReceiptService.java)
=======
            throw new ReceiptNotFoundException("Receipt with id:" + id +"not found");
>>>>>>> parent of 1e12e71 (Update ReceiptService.java)
        }
        return accumulator.accumulate(receipt);
    }

    public List<Receipt> findAllReceipts() {

        return repository.findAll();
    }

    public Receipt saveReceipt(Receipt receipt) {
        UUID id = UUID.randomUUID();
        receipt.setId(id);
        return repository.save(receipt);
    }

    public Receipt findReceiptById(UUID id) {
        return repository.findOne(id);
    }


}
