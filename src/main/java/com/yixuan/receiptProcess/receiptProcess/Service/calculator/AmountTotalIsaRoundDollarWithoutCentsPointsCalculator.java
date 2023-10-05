package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class AmountTotalIsaRoundDollarWithoutCentsPointsCalculator implements PointsCalculator {
    @Override
    public int calculate(Receipt receipt) {
        int points = 0;
        if (receipt.getTotal() % 1 == 0) {
            points += 50;
        }
        return points;
    }
}
