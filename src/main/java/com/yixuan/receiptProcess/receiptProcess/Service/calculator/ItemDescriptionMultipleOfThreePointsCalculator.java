package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Item;
import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.springframework.stereotype.Component;
@Component
public class ItemDescriptionMultipleOfThreePointsCalculator implements PointsCalculator {
    @Override
    public int calculate(Receipt receipt) {
        int points =0;
        for (Item item : receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                points += Math.ceil(item.getPrice() * 0.2);
                System.out.println(item.getShortDescription());

            }
        }
        return points;
    }
}
