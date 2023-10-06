package com.yixuan.receiptProcess.receiptProcess.service.calculator;

import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import org.springframework.stereotype.Component;
@Component
public class PurchaseDateOddCalculator implements PointsCalculator{
    @Override
    public int calculate(Receipt receipt) {
        int points = 0;
        if (receipt.getPurchaseDate().getDayOfMonth() % 2 == 1) {
            points += 6;
        }
        return points;
    }
}