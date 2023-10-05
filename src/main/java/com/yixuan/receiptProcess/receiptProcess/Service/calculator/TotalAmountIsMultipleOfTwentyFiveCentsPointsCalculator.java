package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
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
