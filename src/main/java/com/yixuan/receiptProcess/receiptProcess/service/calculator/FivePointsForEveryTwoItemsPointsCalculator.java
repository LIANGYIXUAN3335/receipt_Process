package com.yixuan.receiptProcess.receiptProcess.service.calculator;

import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class FivePointsForEveryTwoItemsPointsCalculator implements PointsCalculator {
    @Override
    public int calculate(Receipt receipt) {
        return (receipt.getItems().size() / 2) * 5;
    }
}
