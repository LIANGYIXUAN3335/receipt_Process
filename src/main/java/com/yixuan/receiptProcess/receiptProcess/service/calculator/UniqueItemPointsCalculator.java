package com.yixuan.receiptProcess.receiptProcess.service.calculator;

import com.yixuan.receiptProcess.receiptProcess.model.Item;
import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class UniqueItemPointsCalculator implements PointsCalculator {
    @Override
    public int calculate(Receipt receipt) {
        int points = 0;
        Set<Integer> unique = new HashSet<Integer>();
        for (Item item : receipt.getItems()) {
            int hashcode = Objects.hash(item.getPrice(), item.getShortDescription());
            if (unique.contains(hashcode)){
                return 0;
            }
            unique.add(hashcode);
        }
        return receipt.getItems().size() * 5;
    }
}
