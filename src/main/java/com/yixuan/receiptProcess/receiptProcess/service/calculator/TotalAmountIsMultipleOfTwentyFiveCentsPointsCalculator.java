package com.yixuan.receiptProcess.receiptProcess.service.calculator;

import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class TotalAmountIsMultipleOfTwentyFiveCentsPointsCalculator implements PointsCalculator {
    @Override
    public int calculate(Receipt receipt) {
        int points = 0;
        if ((receipt.getTotal() % (0.25)) == 0) {
            points += 25;
        }
        return points;
    }
}
