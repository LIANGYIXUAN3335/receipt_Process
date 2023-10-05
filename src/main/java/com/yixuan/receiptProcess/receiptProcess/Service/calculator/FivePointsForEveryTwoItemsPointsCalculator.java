package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class FivePointsForEveryTwoItemsPointsCalculator implements PointsCalculator {
    @Override
    public int calculate(Receipt receipt) {
        return (receipt.getItems().size() / 2) * 5;
    }
}
