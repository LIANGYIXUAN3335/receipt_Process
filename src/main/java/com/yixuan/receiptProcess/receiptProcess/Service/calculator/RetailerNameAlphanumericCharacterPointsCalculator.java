package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class RetailerNameAlphanumericCharacterPointsCalculator implements PointsCalculator {

    @Override
    public int calculate(Receipt receipt) {
        int points = 0;
        for (int i = 0; i < receipt.getRetailer().length(); i++) {
            char cur = receipt.getRetailer().charAt(i);
            if (Character.isLetter(cur) || Character.isDigit(cur))
                points++;
        }
        return points;
    }
}
