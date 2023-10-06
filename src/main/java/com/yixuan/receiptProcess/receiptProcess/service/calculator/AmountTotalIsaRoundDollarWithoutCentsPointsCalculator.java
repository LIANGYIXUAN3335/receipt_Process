package com.yixuan.receiptProcess.receiptProcess.service.calculator;

import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
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
