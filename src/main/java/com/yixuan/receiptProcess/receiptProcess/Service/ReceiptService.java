package com.yixuan.receiptProcess.receiptProcess.Service;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.Repository.ReceiptRepository;
import com.yixuan.receiptProcess.receiptProcess.Service.accumulator.PointsAccumulatorService;
import com.yixuan.receiptProcess.receiptProcess.Exception.ReceiptNotFoundException;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReceiptService {

    private ReceiptRepository repository;
    private PointsAccumulatorService accumulator;

    public ReceiptService(ReceiptRepository receiptRepository,PointsAccumulatorService accumulator) {
        this.accumulator = accumulator;
        this.repository = receiptRepository;
    }
    public HashMap<String, Integer> getReceiptPoints(UUID id) {
        Receipt receipt = repository.findOne(id);
        if (receipt == null) {
            throw new ReceiptNotFoundException("Receipt with id:" + id +"not found");
        }
        HashMap<String, Integer> map = new HashMap<>();
        map.put("points", accumulator.accumulate(receipt));
        return map;
    }




    public List<Receipt> findAllReceipts() {
        return repository.findAll();
    }

    public Receipt saveReceipt(Receipt receipt) {
        return repository.save(receipt);
    }

    public Receipt findReceiptById(UUID id) {
        return repository.findOne(id);
    }
}
