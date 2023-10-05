package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.springframework.stereotype.Component;
@Component
public class PurchaseDateOddCalculator implements PointsCalculator{
    @Override
    public int calculate(Receipt receipt) {
        int points = 0;
        if (receipt.getPurchaseDate().getDayOfMonth() % 2 == 1) {
            points += 6;
            System.out.println(6);
        }
        return points;
    }
}