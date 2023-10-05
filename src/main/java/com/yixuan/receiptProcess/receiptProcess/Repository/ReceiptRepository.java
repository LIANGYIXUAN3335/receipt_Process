package com.yixuan.receiptProcess.receiptProcess.Repository;

import com.yixuan.receiptProcess.receiptProcess.Model.Item;
import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ReceiptRepository {

    private static List<Receipt> receipts = new ArrayList<>();

    public List<Receipt> findAll() {
        return receipts;
    }

    public Receipt save(Receipt receipt) {
        receipts.add(receipt);
        return receipt;
    }

    public Receipt findOne(UUID id) {
        return receipts.stream()
                .filter(receipt -> receipt.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
